package module.service;

import module.essence.Gender;
import module.essence.Human;
import module.families.Family;
import module.families.Writable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HumanService {
    private final Family<Human> family;
    private Writable<Human> writable;

    public HumanService(Family<Human> family) {
        this.family = family;
    }

    public void save() throws IOException {
        this.save(family);
    }
    public void save(Family<Human> family) throws IOException {
        TXTHandler<Human> txt = new TXTHandler<>();
        txt.save(family);
    }
    public Family<Human> loadFamily() throws IOException, ClassNotFoundException {
        TXTHandler<Human> txt = new TXTHandler<>();
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
        for (Human human: family) {
            members.add(human.getName());
        }
        return members;
    }
    public List<Human> getRelatives(Human human){
        return new ArrayList<>(family.getRelatives(human));
    }
    public Human findByName(String human){
        return family.searchByName(human);
    }

    public void addMember(String name, String day, String month, String year, String gender){
        int day_new = Integer.parseInt(day);
        int month_new = Integer.parseInt(month);
        int year_new = Integer.parseInt(year);
        Human human;
        if (Objects.equals(gender, "м")){
            human = new Human(name, day_new, month_new, year_new, Gender.Male);
            family.addMember(human);
        }
        else if(Objects.equals(gender, "ж")){
            human = new Human(name, day_new, month_new, year_new, Gender.Female);
            family.addMember(human);}
    }
}
