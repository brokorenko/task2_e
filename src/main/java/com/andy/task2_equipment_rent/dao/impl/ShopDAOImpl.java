package com.andy.task2_equipment_rent.dao.impl;

import com.andy.task2_equipment_rent.dao.ShopDAO;
import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.model.Shop;
import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.util.ShopInitializer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShopDAOImpl implements ShopDAO {

    private static Shop shop;

    static {
        try {
            shop = ShopInitializer.initialize();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public RentUnit findEquipment(List<SportEquipment> sportEquipment, Renter renter) {

        RentUnit rentUnit = RentUnit.getInstance();
        boolean isOk;

        for (SportEquipment equipment : sportEquipment) {

            if (shop.getGoods().get(equipment) != null){
                rentUnit.addUnit(equipment);
                shop.setUnit(equipment, shop.getUnit(equipment) - 1);

            } else {

                for (Map.Entry<SportEquipment, Integer> shopEquipment : shop.getGoods().entrySet()) {

                    isOk = true;

                    if (shopEquipment.getKey().getCategory().equals(equipment.getCategory())){

                        if (!equipment.getTitle().equals("")){

                            if (!shopEquipment.getKey().getTitle().equals(equipment.getTitle())){
                                isOk = false;
                            }
                        }

                        if (equipment.getPrice() != 0){

                            if (shopEquipment.getKey().getPrice() != equipment.getPrice()){
                                isOk = false;
                            }
                        }
                        if (isOk){
                            rentUnit.addUnit(shopEquipment.getKey());
                            shop.setUnit(shopEquipment.getKey(), shop.getUnit(shopEquipment.getKey()) - 1);
                            break;
                        }

                    }
                }
            }
        }
        shop.addInRentUnit(renter, rentUnit);

        return rentUnit;
    }

    public Integer nowInRent(Renter renter) {
        if (shop.getInRentCount(renter) == null)
            return 0;
        return shop.getInRentCount(renter).getUnits().size();
    }

    public Set<Map.Entry<SportEquipment, Integer>> dailyReportUnits() {
        return shop.getGoods().entrySet();
    }

    public Set<Map.Entry<Renter, RentUnit>> dailyReportRenters() {
        return shop.getInRent().entrySet();
    }

}
