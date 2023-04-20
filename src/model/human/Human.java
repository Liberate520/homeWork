package model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Human implements Serializable, Comparable<Human>  {

    private Human mother;
    private Human father;
    private String family;
    private String name;
    private Gender gender;
    private LocalDate birthdate;
    private Set<Human> сhildrenList;


    public Human(Human father, Human mother, String family, String name, Gender gender, LocalDate birthdate) {
        this.mother = mother;
        this.father = father;
        this.family = family;
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.сhildrenList = new HashSet<Human>();
    
    }

    public Human(String family, String name, Gender gender, LocalDate birthdate) {
        this (null,null , family, name, gender, birthdate);

    }
    public Human(String family, String name) {
        this (null,null , family, name, null, null);

    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }


    public String getMotherInfo() {

        String res = "Мать: ";
        if (mother!= null){
            res += mother.getInfo();
        }
        else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father!= null){
            res += father.getInfo();
        }
        else {
            res += "неизвестен";
        }
        return res;

    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getGenderInfo() {
        String res = "Пол: ";
        if (gender != null){
            res += this.gender;
        }
        else {
            res += "неизвестен";
        }
        return res;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getBirthdateInfo() {
        String res = "Дата рождения: ";
        if (birthdate != null){
            res += this.birthdate.toString();
        }
        else {
            res += "неизвестна";
        }
        return res;
    }

    public String getСhildrenList() {
        String res = "Дети: \n";
        if (this.сhildrenList.size() != 0){
            res += this.сhildrenList.toString();
        }
        else res += "нет!";

        return res;
    }

//    public boolean addchild (Human child){
//        if (!сhildrenList.contains(child)){
//            сhildrenList.add(child);
//            return true;
//        }
//        else{
//            return false;
//        }
//
//    }

    public void addChildrenList(Human human) {
       this.сhildrenList.add(human);
    }

    public String getInfo(){
//        var formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(family);
        sb.append(" ");
        //sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append("пол: ");
        sb.append(this.getGenderInfo());
        sb.append(", ");
        sb.append(this.getGenderInfo());
        return sb.toString();
                //String.format("\n\nФамилия: %s;\nИмя: %s;\nПол: %s;\nДата рождения: %s;", family, name, gender,birthdate);
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Human)) {
            return false;
        }
         Human human = (Human) object;
        return family.equals(human.family) && name.equals(human.name) ;
    }



    @Override
    public int hashCode() {
        return Objects.hash(family, name, gender, birthdate);
    }

    @Override
    public int compareTo(Human human) {
        return getFamily().compareTo(human.getFamily()) ;
    }

    public enum Gender {
        Mail, Fimale
    }
}
