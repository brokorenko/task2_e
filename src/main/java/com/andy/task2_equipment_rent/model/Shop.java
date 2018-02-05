package com.andy.task2_equipment_rent.model;

import java.util.HashMap;
import java.util.Map;

public class Shop {

    private Map<SportEquipment, Integer> goods = new HashMap<SportEquipment, Integer>();
    private Map<Renter, RentUnit> renters = new HashMap<Renter, RentUnit>();

    private static final Shop shop = new Shop();

    private Shop() {
    }

    public static Shop getInstance(){
        return shop;
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }

    public void setGoods(Map<SportEquipment, Integer> goods) {
        this.goods = goods;
    }

    public Integer getGood(SportEquipment sportEquipment){
        return goods.get(sportEquipment);
    }

    public void setGood(SportEquipment sportEquipment, Integer count){
        goods.put(sportEquipment, count);
    }

    public Map<Renter, RentUnit> getRenters() {
        return renters;
    }

    public void setRenters(Map<Renter, RentUnit> renters) {
        this.renters = renters;
    }

    public void addRenter(Renter renter, RentUnit rentUnit) {
        renters.put(renter, rentUnit);
    }

    public RentUnit getRenter(Renter renter){
        return renters.get(renter);
    }

}
