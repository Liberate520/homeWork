import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    int id;
    String name;
    Gender gender;
    LocalDate birthday;
    LocalDate deathday;
    private Human dad, mom;
    List<Human> children = new ArrayList<>();

    public Human(int id, String name, Gender gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.deathday = null;
    }

    public void setParentDad(Human human_dad, Human human_children){
        if(human_dad.gender == Gender.male){
            dad = human_dad;
            human_dad.children.add(human_children);
        }
    }

    public void setParentMom(Human human_mom, Human human_children){
        if(human_mom.gender == Gender.female){
            mom = human_mom;
            human_mom.children.add(human_children);
        }
    }

    public void setDeathday(LocalDate localDate){
        deathday = localDate;
    }

    public String getParent(){
        return ("Father: " + dad + ". " + "Mother: " + mom);
    }

    public String getChildren(){
        return ("Children: " + children);
    }

    @Override
    public String toString() {
        if(deathday != null){
            return id + "." + name + " " + birthday.getYear() + "-" + deathday.getYear();
        }
        else{
            return id + "." + name + " " + birthday.getYear();
        }

    }

    public String allInfo() {
        if(deathday != null){
            return id + "." + name + " " + birthday + "/" + deathday + "\n" + getParent() + "\n" + getChildren();
        }else{
            return id + "." + name + " " + birthday + "\n" + getParent() + "\n" + getChildren();
        }

    }
}
