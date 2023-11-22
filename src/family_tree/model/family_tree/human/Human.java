package family_tree.model.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, FamilyGroupItems {

    static ArrayList<String> snilss = new ArrayList();
    private String snils;
    private String fam;
    private String name;
    private Gender gender;
    private LocalDate dr;
    private LocalDate dead;
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    public Human(String snils, String fam, String name, LocalDate dr) {
        //Делаем проверку, вдруг такой снилс уже есть
        for (String val:snilss
             ) {
            if (val.equals(snils)) return;
        }

        this.snils = snils;
        this.fam = fam;
        this.name = name;
        this.dr = dr;
        //this.gender = gender;
        snilss.add(snils);


    }

    public String getSnils() {
        return snils;
    }

    public String getFam() {
        return fam;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDr() {
        return dr;
    }

    public LocalDate getDead() {
        return dead;
    }

    public int getAge(){
        LocalDate toDate = LocalDate.now();
        Period period = Period.between(dr, toDate);
        return period.getYears();
    }

    public void AddMother(Human mother){
        this.mother = mother;
    }

    public void AddFather(Human father){
        this.father = father;
    }

    public String GetMother(){
        return mother.toString();
    }

    public String GetFather(){
        return father.toString();
    }

    public void AddChildren(Human child){
        for (Human val:children
        ) {
            if (val.snils.equals(child.snils)) return;
        }
        children.add(child);
    }

    public String GetChildren(){
        StringBuilder str = new StringBuilder();
        for (Human val: children
             ) {
            str.append(val.toString() +"\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return " СНИЛС -'" + snils + '\'' +
                ", ФАМИЛИЯ -'" + fam + '\'' +
                ", Имя - '" + name + '\'' +
                ", возраст - " + this.getAge() + '\'' +
                ", пол - " + gender;
    }
    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
