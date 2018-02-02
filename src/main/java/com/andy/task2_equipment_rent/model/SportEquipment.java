package com.andy.task2_equipment_rent.model;

public class SportEquipment {
    private enum category {SKI, SKATES, SLEIGH};

    private String title;
    private int price;
    private category category;

    public SportEquipment() {
    }

    public SportEquipment(String title, int price, SportEquipment.category category) {
        this.title = title;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SportEquipment.category getCategory() {
        return category;
    }

    public void setCategory(SportEquipment.category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportEquipment)) return false;

        SportEquipment that = (SportEquipment) o;

        if (price != that.price) return false;
        if (!title.equals(that.title)) return false;
        return category == that.category;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + price;
        result = 31 * result + category.hashCode();
        return result;
    }
}
