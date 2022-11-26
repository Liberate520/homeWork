package HW_6;

public class NoteBook {
    private Integer ram;
    private Integer res;
    private Integer hdd;


    public NoteBook() {
    }

    public NoteBook(Integer ram, Integer res, Integer hdd) {
        this.ram = ram;
        this.res = res;
        this.hdd = hdd;
    }

    @Override
    public String toString(){
        return "Notebook_" + ram+"GB_RAM_"+hdd+ "GB_HDD_"+ res+ "p";

 }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

    public Integer getHdd() {
        return hdd;
    }

    public void setHdd(Integer hdd) {
        this.hdd = hdd;
    }
}