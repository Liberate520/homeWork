import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private HumanGroup humans;
    private MarriageGroup marriages;
    public FamilyTree(){
        humans = new HumanGroup();
        marriages = new MarriageGroup();
    }
    //разрешаем вызвать метод только в пакете
    void addHuman(Human h){
        humans.add(h);
    }

    //разрешаем вызвать метод только в пакете
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
    public String getInfoAll(){
        return "{ humans: \n"
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
