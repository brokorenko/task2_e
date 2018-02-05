package com.andy.task2_equipment_rent.serivce;

import com.andy.task2_equipment_rent.model.criteria.SearchCriteria;
import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.model.SportEquipment;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ShopService {
    RentUnit findEquipment(List<SearchCriteria> equipmentCriteria, Renter renter);
    Set<Map.Entry<SportEquipment, Integer>> dailyReportUnits();
    Set<Map.Entry<Renter, RentUnit>> dailyReportRenters();
}
