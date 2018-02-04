package com.andy.task2_equipment_rent.dao;

import com.andy.task2_equipment_rent.dao.impl.ShopDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private ShopDAO shopDAO = new ShopDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ShopDAO getShopDAO() {
        return shopDAO;
    }
}
