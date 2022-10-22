package HW_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NoteBook {
    private String brand;
    private String ram;
    private boolean ssd;
    private String os;
    private String color;
    private String diagonal;

    public NoteBook() {
    }

    public NoteBook(String brand, boolean ssd, String color) {
        this.brand = brand;
        this.ssd = ssd;
        this.color = color;
    }




    public String toString(){
        if (ssd)
        return brand +"_"+ "ssd" +"_"+ color;
        else
            return brand +"_"+ "hdd" +"_"+ color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(String diagonal) {
        this.diagonal = diagonal;
    }

}
