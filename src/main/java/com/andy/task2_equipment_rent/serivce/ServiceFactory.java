package com.andy.task2_equipment_rent.serivce;

import com.andy.task2_equipment_rent.serivce.impl.ShopServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    private ShopService shopService = new ShopServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public ShopService getShopService() {
        return shopService;
    }
}
