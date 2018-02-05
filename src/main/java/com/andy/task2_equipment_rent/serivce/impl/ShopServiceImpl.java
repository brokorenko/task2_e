package com.andy.task2_equipment_rent.serivce.impl;

import com.andy.task2_equipment_rent.model.criteria.SearchCriteria;
import com.andy.task2_equipment_rent.dao.DAOFactory;
import com.andy.task2_equipment_rent.dao.ShopDAO;
import com.andy.task2_equipment_rent.model.Renter;
import com.andy.task2_equipment_rent.model.RentUnit;
import com.andy.task2_equipment_rent.model.SportEquipment;
import com.andy.task2_equipment_rent.serivce.ShopService;
import com.andy.task2_equipment_rent.serivce.validation.Validator;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShopServiceImpl implements ShopService {

    private DAOFactory daoFactory = DAOFactory.getInstance();
    private ShopDAO shopDAO = daoFactory.getShopDAO();
    private Validator validator;

    public RentUnit findEquipment(List<SearchCriteria> equipmentCriteria, Renter renter) {

        validator = Validator.getInstance();

        validator.validate(equipmentCriteria, renter);

        return shopDAO.findEquipment(equipmentCriteria, renter);
    }

    public Set<Map.Entry<SportEquipment, Integer>> dailyReportUnits() {
        return shopDAO.dailyReportUnits();
    }

    public Set<Map.Entry<Renter, RentUnit>> dailyReportRenters() {
        return shopDAO.dailyReportRenters();
    }

}
