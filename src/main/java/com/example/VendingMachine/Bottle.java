package com.example.VendingMachine;

public class Bottle extends Product{
    private double volume;


    public Bottle(String name, double price, double volume) {
        super(name, price);
        this.volume = volume;
    }

    public Bottle(double volume) {
        this.volume = volume;
    }


    @Override
    public String toString() {
        return super.toString() + ", volume=" + volume;
    }
}
