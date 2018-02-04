package com.andy.task2_equipment_rent.model;

import java.util.ArrayList;
import java.util.List;

public class RentUnit {

    private List<SportEquipment> units = new ArrayList<SportEquipment>();

    private RentUnit() {
    }

    public static RentUnit getInstance(){
        return new RentUnit();
    }

    public List<SportEquipment> getUnits() {
        return units;
    }

    public void setUnits(List<SportEquipment> units) {
        this.units = units;
    }

    public void addUnit(SportEquipment sportEquipment){
        if (sportEquipment != null){
            units.add(sportEquipment);
        }

    }

    public SportEquipment getUnit(int index){
        return units.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RentUnit)) return false;

        RentUnit rentUnit = (RentUnit) o;

        return units.equals(rentUnit.units);
    }

    @Override
    public int hashCode() {
        return units.hashCode();
    }

    @Override
    public String toString() {
        return "RentUnit{" +
                "units=" + units +
                '}';
    }
}
