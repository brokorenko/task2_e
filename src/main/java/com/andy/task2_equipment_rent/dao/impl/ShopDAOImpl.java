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

    private static final Shop shop = ShopInitializer.initialize();


    public RentUnit findEquipment(List<SportEquipment> sportEquipment, Renter renter) {

        RentUnit rentUnit = RentUnit.getInstance();

        for (SportEquipment equipment : sportEquipment) {

            if (shop.getGoods().get(equipment) != null){
                rentUnit.addUnit(equipment);
                shop.setUnit(equipment, shop.getUnit(equipment) - 1);
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
