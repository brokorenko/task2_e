package com.andy.task2_equipment_rent.dao.util;

import com.andy.task2_equipment_rent.model.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;

public class ShopUnit {

    private static ShopUnit shopUnit = new ShopUnit();

    private ShopUnit() {
    }

    public static ShopUnit getInstance(){
        return shopUnit;
    }

    public static Map<Criteria, String> getShopUnit(String equipment) {

        StringBuilder category = new StringBuilder();
        StringBuilder title = new StringBuilder();
        StringBuilder price = new StringBuilder();
        StringBuilder count = new StringBuilder();

        String[] letters = equipment.split("");

        int i;

        for (i = 0; i < letters.length; i++) {
            if (letters[i].equals(":")) {
                break;
            }
            category.append(letters[i]);
        }

        while (!letters[i].equals("=")) {
            i++;
        }

        i++;

        for (; i < letters.length; i++) {
            if (letters[i].equals(",")) {
                break;
            }
            title.append(letters[i]);
        }

        while (!letters[i].equals("=")) {
            i++;
        }

        i++;

        for (; i < letters.length; i++) {
            if (letters[i].equals(",")) {
                break;
            }
            price.append(letters[i]);
        }

        while (!letters[i].equals("=")) {
            i++;
        }

        i++;

        for (;i < letters.length - 1; i++) {
            if (letters[i].equals(",")) {
                break;
            }
            count.append(letters[i]);
        }

        Map<Criteria, String> shopGoodsFields = new HashMap<Criteria, String>();
        shopGoodsFields.put(Criteria.CATEGORY, category.toString());
        shopGoodsFields.put(Criteria.TITLE, title.toString());
        shopGoodsFields.put(Criteria.PRICE, price.toString());
        shopGoodsFields.put(Criteria.COUNT, count.toString());

        return shopGoodsFields;
    }
}
