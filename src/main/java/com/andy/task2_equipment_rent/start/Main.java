package com.andy.task2_equipment_rent.start;

import com.andy.task2_equipment_rent.model.criteria.Criteria;
import com.andy.task2_equipment_rent.model.criteria.SearchCriteria;
import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.serivce.ServiceFactory;
import com.andy.task2_equipment_rent.serivce.ShopService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ShopService shopService = serviceFactory.getShopService();

        Map<Criteria, Object> map = new HashMap<Criteria, Object>();
        map.put(Criteria.PRICE, 10);
        SearchCriteria searchCriteria = new SearchCriteria(map, "SKI");

        List<SearchCriteria> listEquioment = new ArrayList<SearchCriteria>();
        listEquioment.add(searchCriteria);
        Renter renter = new Renter("Va");
        Renter renter2 = new Renter("Va2");
        Renter renter3 = new Renter("Va3");
        Renter renter4 = new Renter("Va4");
        Renter renter5 = new Renter("Va5");
        RentUnit rentUnit = shopService.findEquipment(listEquioment, renter);
        RentUnit rentUnit2 = shopService.findEquipment(listEquioment, renter2);
        RentUnit rentUnit3 = shopService.findEquipment(listEquioment, renter3);
        RentUnit rentUnit4 = shopService.findEquipment(listEquioment, renter4);
        RentUnit rentUnit5 = shopService.findEquipment(listEquioment, renter5);

        if (rentUnit != null) {
            System.out.println(rentUnit.getUnits());
            System.out.println(rentUnit2.getUnits());
            System.out.println(rentUnit3.getUnits());
            System.out.println(rentUnit4.getUnits());
            System.out.println(rentUnit5.getUnits());

            System.out.println("----------------------------------------------------------");
            System.out.println(shopService.dailyReportRenters());
            System.out.println("----------------------------------------------------------");
            System.out.println(shopService.dailyReportUnits());
            System.out.println("----------------------------------------------------------");

        } else {
            System.out.println("Shop is empty");
        }
    }
}

