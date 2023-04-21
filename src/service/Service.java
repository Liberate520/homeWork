package service;

import families.Family;
import families.Writable;

import java.io.IOException;

public class Service {
    private Writable writable;
    private Family family;

    public Service(Family family) {
        this.family = family;
    }
    public void save(Family family) throws IOException {
        TXTHandler txt = new TXTHandler();
        txt.save(family);
    }
    public Family loadFamily() throws IOException, ClassNotFoundException {
        TXTHandler txt = new TXTHandler();
        return txt.loadFamily();
    }
    public void sortByName(){
        family.getPeopleList().sort(new HumanComporatorByName());
    }
    public void sortByDate(){
        family.getPeopleList().sort(new HumanComporatorByDate());
    }
}
