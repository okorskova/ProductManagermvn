package ru.netology.productManager;

public class Smartphone extends Product {
    private String producer;

    public Smartphone(int id, String name, String producer, int price) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
