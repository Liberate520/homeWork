package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {
    private int humanID=1;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother, father;
    private List<Human> childrens;

    public Human(String name, LocalDate bDate, LocalDate dDate, Gender gender,Human mother,Human father) {
        humanID++;
        this.name = name;
        this.birthDate = bDate;
        this.deathDate = dDate;
        this.mother = mother;
        this.father = father;
        this.childrens = new ArrayList<>();
        this.gender=gender;
    }

    public Human(String name, LocalDate bDate,Gender gender,Human mother,Human father) {
        humanID++;
        this.name = name;
        this.birthDate = bDate;
        this.deathDate = null;
        this.mother = mother;
        this.father = father;
        this.gender=gender;
        this.childrens = new ArrayList<>();
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, Objects.requireNonNullElse(deathDate, currentDate)).getYears();
    }
    public String getName(){
        return name;
    }
    public int getHumanID(){
        return humanID;
    }
    public void setHumanID(int num){
        this.humanID=num;
    }
    public boolean  addChild(Human child){
        if (childrens.contains(child)) {
            return true;
        }
        childrens.add(child);
        return true;
    }
    public Human getFather(){
        return father;
    }
    public Human getMother(){
        return mother;
    }
    public String getFatherName(){
        String res="";
        Human father = getFather();
        res += Objects.requireNonNullElse(this.father.name, "Не известен");
        return res;
    }
    public String getMotherName(){
        String res="";
        Human mother = getMother();
        if (this.mother.name!=null)
            res += this.mother.name;
        else res+="Не известен";
        return res;
    }
    public String getGender(){
        String res="";
        if(this.gender==Gender.Male)
        {
            res+="Мужской";
        }
        else res+="Женский";
        return res;
    }
//    public List<Human>getParents(){
//        List<Human> parents = new ArrayList<>(2);
//        if(father!=null){
//            parents.add(father);
//        }
//        if(mother!=null){
//            parents.add(mother);
//        }
//        return parents;
//    }
public String getParents(){
    StringBuilder sb = new StringBuilder();
    if (this.father!=null||this.mother!=null){
    if(this.father!=null){
        sb.append("Отец: ");
        sb.append(getFatherName());
        sb.append(" ");
    }
    if (this.mother!=null)
    {
        sb.append("Мать: ");
        sb.append(getMotherName());
        sb.append(" ");
    }
    }
    else sb.append("Родители не известны");
        return sb.toString();
    }
    public String getChildrens(){
        if(!this.childrens.isEmpty()){
            StringBuilder sb = new StringBuilder();
            for (Human child:childrens
                 ) {
                sb.append(child.getName());
                sb.append(" ");
            }
            return sb.toString();
        }
        else return "детей нет";
    }
    public void setMother(Human mother){
        this.mother=mother;
    }
    public void setFather(Human father){
        this.father=father;
    }

    public String getDeathStatus(){
        if(deathDate!=null){
            if(gender==Gender.Female){return "мертва";}
            else return "мертв";
        }
        else {
            if(gender==Gender.Female){return "жива";}
            else return "жив";
        }
    }
    @Override
    public String toString() {return GetInfo();}
    public String GetInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(getName());
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", Статус: ");
        sb.append(getDeathStatus());
        sb.append(", Дата рождения: ");
        sb.append(birthDate.getDayOfMonth());
        sb.append("-");
        sb.append(birthDate.getMonth());
        sb.append("-");
        sb.append(birthDate.getYear());
        if(deathDate!=null) {
            sb.append(", Дата смерти: ");
            sb.append(deathDate.getDayOfMonth());
            sb.append("-");
            sb.append(deathDate.getMonth());
            sb.append("-");
            sb.append(deathDate.getYear());
        }
        sb.append(", Дети: ");
        if(childrens==null)
        {
            sb.append("Нет");
        }
        sb.append(getChildrens());
        sb.append(", Родители: ");
        sb.append(getParents());
        return sb.toString();
    }
}