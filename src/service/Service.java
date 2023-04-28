package service;

import essence.Essence;
import essence.Gender;
import essence.Human;
import families.Family;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service<T extends Essence<T>> {
    private final Family<T> family;

    public Service(Family<T> family) {
        this.family = family;
    }

    public void save() throws IOException {
        this.save(family);
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
    public List<String> getFamily(){
        List<String> members = new ArrayList<>();
        for (T human: family) {
            members.add(human.getName());
        }
        return members;
    }
    public List<T> getRelatives(T human){
        List<T> arr = new ArrayList<>(family.getAncestors(human));
        arr.addAll(family.getDescendants(human));
        return arr;
    }
    public T findByName(String human){
        return family.searchByName(human);
    }

//    public void addMember(String name, int day, int month, int year, Gender gender){
//      Human newww = new Human(name, day, month, year, gender);
//      family.addMember((T) newww);
//    }
}
