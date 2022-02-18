package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product {
    private String firm;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String firm) {
        super(id, name, price);
        this.firm = firm;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return firm.equals(that.firm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firm);
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "firm='" + firm + '\'' +
                '}';
    }
}
