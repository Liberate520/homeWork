import java.util.TreeMap;

public class Laptops {
    int id;
    int price;
    String model;
    String brand;
    int screenSize;
    String colour;
    int hardDiskSize;
    String operatingSystem;
    String gaphicsCardDescription;
    int CPUspeed;
    int itemWeight;
    int totalUSBports;
    String connectivityTechnology;

    public Laptops(String model, int id) {
        this.model = model;
        this.id = id;
    }

    public Laptops(String model, int id, String brand) {
        this.model = model;
        this.id = id;
        this.brand = brand;
    }

    public Laptops() {
    }

    public int getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getHardDiskSize() {
        return hardDiskSize;
    }

    public void setHardDiskSize(int hardDiskSize) {
        this.hardDiskSize = hardDiskSize;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getGaphicsCardDescription() {
        return gaphicsCardDescription;
    }

    public void setGaphicsCardDescription(String gaphicsCardDescription) {
        this.gaphicsCardDescription = gaphicsCardDescription;
    }

    public int getCPUspeed() {
        return CPUspeed;
    }

    public void setCPUspeed(int CPUspeed) {
        this.CPUspeed = CPUspeed;
    }

    public void setItemWeight(int itemWeight) {
        this.itemWeight = itemWeight;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public void setTotalUSBports(int totalUSBports) {
        this.totalUSBports = totalUSBports;
    }

    public int getTotalUSBports() {
        return totalUSBports;
    }

    public String getConnectivityTechnology() {
        return connectivityTechnology;
    }

    public void setConnectivityTechnology(String connectivityTechnology) {
        this.connectivityTechnology = connectivityTechnology;
    }

    public String[] filter(int num, int down, int up) {
        TreeMap<Integer, String> map = new TreeMap<>();

        return map;
    }

    @Override
    public String toString() {
        return model + " " + brand + " " + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Laptops l = (Laptops) obj;
        if (this.model.equals(l.model) && this.brand.equals(l.brand)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return model.hashCode() + 13 * brand.hashCode();
    }
}
