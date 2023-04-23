package service;

import essence.Essence;
import essence.Human;
import families.Family;

import java.io.IOException;

public class Service<T extends Essence<T>> {
    private final Family<T> family;

    public Service(Family<T> family) {
        this.family = family;
    }

    public void save(Family<T> family) throws IOException {
        TXTHandler<T> txt = new TXTHandler<>();
        txt.save(family);
    }
    public Family<T> loadFamily() throws IOException, ClassNotFoundException {
        TXTHandler<T> txt = new TXTHandler<>();
        return txt.loadFamily();
    }
    public void sortByName(){
        family.getPeopleList().sort(new HumanComparatorByName<>());
    }
    public void sortByDate(){
        family.getPeopleList().sort(new HumanComparatorByDate<>());
    }
    public StringBuilder getFamily(){
        StringBuilder sb = new StringBuilder();
        for (T human: family) {
            sb.append(human.getName());
            sb.append("\n");
        }
        return sb;
    }
}
