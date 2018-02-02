package com.andy.task2_equipment_rent.start;

public class Main {
    public static void main(String[] args) {
        Integer[] items = {1,2};
        Integer[] newItems = items.clone();
        newItems[0] = 3;
        System.out.println(items[0]);
        System.out.println(newItems[0]);

        int[] it = {1,2};
        int[] newIt = it.clone();
        newIt[0] = 3;
        System.out.println(it[0]);
        System.out.println(newIt[0]);

        Integer[][] itD = {{1,2}, {1,2}};
        Integer[][] newItD = itD.clone();
        newItD[0][1] = 3;
        System.out.println(itD[0][1]);
        System.out.println(newItD[0][1]);

        int[][] itemsD = {{1,2}, {1,2}};
        int[][] newItemsD = itemsD.clone();
        newItemsD[0][1] = 3;
        System.out.println(itemsD[0][1]);
        System.out.println(newItemsD[0][1]);
    }
}

