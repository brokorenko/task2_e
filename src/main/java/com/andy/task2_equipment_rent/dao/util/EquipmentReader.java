package com.andy.task2_equipment_rent.dao.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EquipmentReader implements AutoCloseable {

    private static FileReader fileReader;
    private static Scanner scanner;
    private static EquipmentReader equipmentReader;

    static {

        try {
            fileReader = new FileReader(FileName.getFilename());
            equipmentReader = new EquipmentReader();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find db file");
        }

        scanner = new Scanner(fileReader).useDelimiter("\\s*\\n\\s*");
    }

    private EquipmentReader(){
    }

    public static boolean hasEquipment(){
        return scanner.hasNext();
    }

    public static String getEquipment(){
        return scanner.next();
    }

    public static EquipmentReader getInstance(){
        return equipmentReader;
    }

    public void close() throws Exception {
        scanner.close();
        fileReader.close();
    }
}
