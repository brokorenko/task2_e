package com.andy.task2_equipment_rent.start;

import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.serivce.ServiceFactory;
import com.andy.task2_equipment_rent.serivce.ShopService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ShopService shopService = serviceFactory.getShopService();

        SportEquipment sportEquipment = new SportEquipment();
        sportEquipment.setCategory(SportEquipment.Category.SKI);
        sportEquipment.setTitle("FOX");
        sportEquipment.setPrice(10);

        List<SportEquipment> listEquioment = new ArrayList<SportEquipment>();
        listEquioment.add(sportEquipment);
        Renter renter = new Renter("Vasa");
        Renter renter2 = new Renter("Vasa2");
        Renter renter3 = new Renter("Vasa3");
        Renter renter4 = new Renter("Vasa4");
        Renter renter5 = new Renter("Vasa5");
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

