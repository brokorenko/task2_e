package com.andy.task2_equipment_rent.model;

public class SportEquipment {
    public enum Category {SKI, SKATES, SLEIGH}

    private String title = "";
    private Integer price = 0;
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

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        return category == that.category;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
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
