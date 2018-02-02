package com.andy.task2_equipment_rent.dao.impl;

import com.andy.task2_equipment_rent.dao.ShopDAO;
import com.andy.task2_equipment_rent.model.Shop;
import com.andy.task2_equipment_rent.util.EquipmentReader;

import java.io.FileNotFoundException;

public class ShopDAOImpl implements ShopDAO {

    public void initialize(Shop shop) {
        EquipmentReader equipmentReader = EquipmentReader.getInstance();

        if (equipmentReader.hasEquipment()){
            String equipment = equipmentReader.getEquipment();

        }
    }
}
