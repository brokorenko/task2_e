package com.andy.task2_equipment_rent.util;

import java.util.ResourceBundle;

public class FileName {

    private static final ResourceBundle rb = ResourceBundle.getBundle("config");

    private FileName() {
    }

    public static String getFilename(){
        return rb.getString("fileName");
    }
}
