package com.andy.task2_equipment_rent.serivce.validation;

import com.andy.task2_equipment_rent.model.criteria.SearchCriteria;
import com.andy.task2_equipment_rent.model.Renter;

import java.util.List;

public class Validator {

    private static Validator validator = new Validator();

    private Validator() {
    }

    public void validate(List<SearchCriteria> equipmentCriteria, Renter renter){

        if (equipmentCriteria.size() >= 3){
            throw new IllegalArgumentException("You can't get more than 3 items");
        }

        for (SearchCriteria criteria : equipmentCriteria){
            if (criteria.getCategory() == null) {
                throw new IllegalArgumentException("You should chose a category");
            }
        }
    }

    public static Validator getInstance(){
        return validator;
    }
}
