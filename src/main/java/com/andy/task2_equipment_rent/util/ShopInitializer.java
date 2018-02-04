package com.andy.task2_equipment_rent.util;

import com.andy.task2_equipment_rent.model.Shop;
import com.andy.task2_equipment_rent.model.SportEquipment;

public class ShopInitializer {

    private static final StringBuilder category = new StringBuilder();
    private static final StringBuilder title = new StringBuilder();
    private static final StringBuilder price = new StringBuilder();
    private static final StringBuilder count = new StringBuilder();

    private static final Shop shop = Shop.getInstance();

    private ShopInitializer() {
    }

    public static Shop initialize() throws Exception {

        EquipmentReader equipmentReader = EquipmentReader.getInstance();

        try {
            while (EquipmentReader.hasEquipment()){
                ShopInitializer.addUnit(equipmentReader.getEquipment(), shop);
            }
        } finally {
            equipmentReader.close();
        }
        return shop;
    }

    private static void addUnit(String equipment, Shop shop){

        category.setLength(0);
        title.setLength(0);
        price.setLength(0);
        count.setLength(0);

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

        shop.setUnit(new SportEquipment(String.valueOf(title),
                Integer.valueOf(String.valueOf(price)),
                        SportEquipment.Category.valueOf(String.valueOf(category).trim())),
                Integer.valueOf(String.valueOf(count)));
    }
}
