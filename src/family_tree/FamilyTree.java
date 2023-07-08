package family_tree;

import family_tree.human.Human;
import family_tree.human.HumanGroup;
import family_tree.marriage.Marriage;
import family_tree.marriage.MarriageGroup;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private HumanGroup humans;
    private MarriageGroup marriages;
    //!!! делаем конструктор доступным только для ServiceFamilyTree. Можно ли так делать?
    FamilyTree(){
        humans = new HumanGroup();
        marriages = new MarriageGroup();
    }
    //разрешаем вызвать метод только в ServiceFamilyTree
    void addHuman(Human h){
        humans.add(h);
    }

    //разрешаем вызвать метод только в ServiceFamilyTree
    void addMarriage(Marriage m){
        marriages.add(m);
    }

    public Human getHumanById(int id){
        for(Human h : humans)
            if(h.getId() == id)
                return h;
        return null;
    }
    public Marriage getMarriageById(int id){
        for(Marriage m : marriages)
            if(m.getId() == id)
                return m;
        return null;
    }

    public String getHumansInfo(){
        return humans.getInfo();
    }
    public String getMarriagesInfo(){
        List<String> strings = new ArrayList<>();
        for (Marriage m : marriages)
            strings.add(m.getInfo());
        return String.join("\n", strings);
    }
    public String getInfoAll(){
        return "{ humans: \n"
                + getHumansInfo()
                + ",\nmarriages: \n"
                + getMarriagesInfo()
                + "\n}";
    }

    public void sortHumansByName(){
        humans.sortByName();
    }

    public void sortHumansByAge(){
        humans.sortByAge();
    }

    @Override
    public String toString() {
        return getInfoAll();
    }
}
