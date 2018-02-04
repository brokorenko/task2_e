package com.andy.task2_equipment_rent.serivce.validation;

import com.andy.task2_equipment_rent.dao.ShopDAO;
import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.SportEquipment;

import java.util.List;

public class Validator {

    private static Validator validator = new Validator();

    private Validator() {
    }

    public void validate(List<SportEquipment> sportEquipment, Renter renter, ShopDAO shopDAO){

        if (sportEquipment.size() >= 3){
            throw new IllegalArgumentException("You can't get more than 3 items");
        }
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (shopDAO.nowInRent(renter) >= 3) {
            throw new IllegalArgumentException("You've got too much stuff in rent, please return it back!");
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
        for (SportEquipment equipment : sportEquipment){
            if (equipment.getCategory() == null) {
                throw new IllegalArgumentException("You should chose a category");
            }
            if (equipment.getTitle() == null) {
                throw new IllegalArgumentException("You should chose a title");
            }
            if (equipment.getPrice() == 0) {
                throw new IllegalArgumentException("You should chose a price");
            }
        }
    }

    public static Validator getInstance(){
        return validator;
    }
}
