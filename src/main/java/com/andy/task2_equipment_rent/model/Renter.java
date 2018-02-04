package com.andy.task2_equipment_rent.model;

public class Renter {

    private String name;

    public Renter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Renter)) return false;

        Renter renter = (Renter) o;

        return name.equals(renter.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Renter{" +
                "name='" + name + '\'' +
                '}';
    }
}
