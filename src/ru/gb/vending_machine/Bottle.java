package ru.gb.vending_machine;
public class Bottle extends Product {

    private Double volume;

    public Bottle(String name, Double price, Double volume) {
        super(name, price);
        this.volume = volume;
    }

    public Double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return super.toString() + ", volume " + volume;
    }
    
}
