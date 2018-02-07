package com.andy.task2_equipment_rent.dao.util;

import com.andy.task2_equipment_rent.model.Shop;
import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.model.criteria.Criteria;

import java.util.Map;

public class ShopInitializer {

    private static final Shop shop = Shop.getInstance();

    private ShopInitializer() {
    }

    public static Shop initialize() throws Exception {

        EquipmentReader equipmentReader = EquipmentReader.getInstance();
        Map<Criteria, String> shopGoodFields;

        try {

            while (EquipmentReader.hasEquipment()){

                shopGoodFields = ShopUnit.getShopUnit(EquipmentReader.getEquipment());

                shop.setGood(new SportEquipment(shopGoodFields.get(Criteria.TITLE),
                                Integer.valueOf(shopGoodFields.get(Criteria.PRICE)),
                                SportEquipment.Category.valueOf(shopGoodFields.get(Criteria.CATEGORY).trim())),
                        Integer.valueOf(shopGoodFields.get(Criteria.COUNT)));


            }
        } finally {
            equipmentReader.close();
        }
        return shop;
    }
}
