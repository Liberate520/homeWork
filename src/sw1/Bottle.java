package sw1;

public class Bottle extends Product {

    private double volume;
    private String name;

    public Bottle(double cost, String name, double volume) {
        super(cost, name);
        this.volume = volume;
    }

    @Override
    public double getCost() {
        return getCost() * getVolume();
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return super.toString() + " " + volume;
    }
}
