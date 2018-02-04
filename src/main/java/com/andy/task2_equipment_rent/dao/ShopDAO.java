package com.andy.task2_equipment_rent.dao;

import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.model.SportEquipment;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ShopDAO {
    RentUnit findEquipment(List<SportEquipment> sportEquipment, Renter renter);
    Integer nowInRent(Renter renter);

    Set<Map.Entry<SportEquipment, Integer>> dailyReportUnits();

    Set<Map.Entry<Renter, RentUnit>> dailyReportRenters();
}
