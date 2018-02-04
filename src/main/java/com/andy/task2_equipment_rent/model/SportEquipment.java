package com.andy.task2_equipment_rent.model;

public class SportEquipment {
    public enum Category {SKI, SKATES, SLEIGH}

    private String title;
    private Integer price;
    private Category category;

    public SportEquipment() {
    }

    public SportEquipment(String title, Integer price, SportEquipment.Category category) {
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

    public void setPrice(Integer price) {
        this.price = price;
    }

    public SportEquipment.Category getCategory() {
        return category;
    }

    public void setCategory(SportEquipment.Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SportEquipment)) return false;

        SportEquipment that = (SportEquipment) o;

        if (!title.equals(that.title)) return false;
        if (!price.equals(that.price)) return false;
        return category == that.category;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "SportEquipment{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
