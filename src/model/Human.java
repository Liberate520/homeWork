package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, GroupItem {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate deathday;
    private Human dad, mom;
    private List<Human> children = new ArrayList<>();

    public Human(int id, String name, Gender gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.deathday = null;
    }

    public void setParent(Human human_parent){
        if(human_parent.gender == Gender.male){
            this.dad = human_parent;
            human_parent.children.add(this);
        }else{
            this.mom = human_parent;
            human_parent.children.add(this);
        }
    }

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public Gender getGender(){return gender;}

    public LocalDate getBirthday(){
        return birthday;
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
