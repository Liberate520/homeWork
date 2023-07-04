import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humans;
    private List<Marriage> marriages;
    private int idMarriage=0;
    public FamilyTree(){
        humans = new ArrayList<>();
        marriages = new ArrayList<>();
    }
    public void addHuman(Human h){
        humans.add(h);
    }
    //При нарушении условий заключения брака возвращаем null
    public Marriage addMarriage(LocalDate startDate, Human wife, Human husband){
        Marriage marriage = new Marriage(idMarriage, startDate, wife, husband);
        if(marriage.getIsError()) return null;
        marriages.add(marriage);
        idMarriage++;
        return marriage;
    }

    public String getInfoMembers(){
        List<String> familyMembers = new ArrayList<>();
        for (Human h : humans)
            familyMembers.add(h.getInfo());
        return String.join("\n", familyMembers);
    }
    public String getInfoMarriages(){
        List<String> strings = new ArrayList<>();
        for (Marriage m : marriages)
            strings.add(m.getInfo());
        return String.join("\n", strings);
    }
    public Human getHumanById(int id){
        for(Human h : humans)
            if(h.getId() == id)
                return h;
        return null;
    }
    public String getInfoAll(){
        return "{ members: \n"
                + getInfoMembers()
                + ",\nmarriages: \n"
                + getInfoMarriages()
                + "\n}";
    }
    @Override
    public String toString() {
        return getInfoAll();
    }
}
