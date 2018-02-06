package com.andy.task2_equipment_rent.dao.impl;

import com.andy.task2_equipment_rent.model.criteria.SearchCriteria;
import com.andy.task2_equipment_rent.dao.ShopDAO;
import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.model.Shop;
import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.dao.util.CriteriaAndGoodsComparator;
import com.andy.task2_equipment_rent.dao.util.ShopInitializer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShopDAOImpl implements ShopDAO {

    private static Shop shop;

    static {
        try {
            shop = ShopInitializer.initialize();
        } catch (Exception e) {
            throw new IllegalArgumentException("Cant initialize shop");
        }
    }


    public RentUnit findEquipment(List<SearchCriteria> searchCriteria, Renter renter){

        if (shop.getRenter(renter) != null) {
            if (shop.getRenter(renter).getUnits().size() + searchCriteria.size() >= 3){
                throw new IllegalArgumentException("You should return our stuff!");
            }
        }

        RentUnit rentUnit = RentUnit.getInstance();
        CriteriaAndGoodsComparator criteriaComparator = CriteriaAndGoodsComparator.getInstance();

        for (SearchCriteria criteria : searchCriteria) {

            for (Map.Entry<SportEquipment, Integer> shopGoodsEntry : shop.getGoods().entrySet()){

                if (criteriaComparator.compareCriteriaWithShopGoods(criteria, shopGoodsEntry)){
                    rentUnit.addUnit(shopGoodsEntry.getKey());
                    shop.setGood(shopGoodsEntry.getKey(), shop.getGood(shopGoodsEntry.getKey()) - 1);
                    break;
                }
            }
        }

        shop.addRenter(renter, rentUnit);

        return rentUnit;
    }

    public Map<SportEquipment, Integer> dailyReportUnits() {
        return shop.getGoods();
    }

    public Map<Renter, RentUnit> dailyReportRenters() {
        return shop.getRenters();
    }

}
