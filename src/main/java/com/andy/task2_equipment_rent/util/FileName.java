package com.andy.task2_equipment_rent.util;

import java.util.ResourceBundle;

public final class FileName {
    private static final ResourceBundle rb = ResourceBundle.getBundle("config");

    private FileName() {
    }

    public static String getFilename(){
        return rb.getString("fileName");
    }
}
