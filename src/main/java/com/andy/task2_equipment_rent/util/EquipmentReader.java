package com.andy.task2_equipment_rent.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public final class EquipmentReader {
    private FileReader fileReader;
    private Scanner scanner;
    private static EquipmentReader equipmentReader;

    {
        fileReader = new FileReader(FileName.getFilename());
        scanner = new Scanner(fileReader).useDelimiter("\\s*\\n\\s*");
        equipmentReader = new EquipmentReader();
    }

    private EquipmentReader() throws FileNotFoundException {
    }

    public boolean hasEquipment(){
        return scanner.hasNext();
    }

    public String getEquipment(){
        return scanner.next();
    }

    public static EquipmentReader getInstance(){
        return equipmentReader;
    }
}
