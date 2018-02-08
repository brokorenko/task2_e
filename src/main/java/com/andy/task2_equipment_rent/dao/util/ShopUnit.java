package com.andy.task2_equipment_rent.dao.util;

import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.model.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ShopUnit {

    private static ShopUnit shopUnit = new ShopUnit();
    private static final String regex = "( : +TITLE=|, PRICE=|, COUNT=|;)";
    private static final Pattern p = Pattern.compile(regex);

    private ShopUnit() {
    }

    public static ShopUnit getInstance(){
        return shopUnit;
    }

    public static Map<Criteria, String> getShopUnit(String equipment) {

        String[] criteria = p.split(equipment);

        Map<Criteria, String> shopGoodsFields = new HashMap<Criteria, String>();
        shopGoodsFields.put(Criteria.CATEGORY, criteria[0]);
        shopGoodsFields.put(Criteria.TITLE, criteria[1]);
        shopGoodsFields.put(Criteria.PRICE, criteria[2]);
        shopGoodsFields.put(Criteria.COUNT, criteria[3]);

        return shopGoodsFields;
    }
}
