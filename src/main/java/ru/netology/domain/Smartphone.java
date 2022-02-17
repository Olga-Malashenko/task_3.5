package ru.netology.domain;

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
}
