package model.human;

import java.io.Serializable;
import java.time.LocalDate;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }


    public Set<Human> getСhildrenList() {
        return сhildrenList;
    }

    public boolean child (Human human){
        if (!сhildrenList.contains(human)){
            return true;
        }
        else{
            return false;
        }

    }

    public void addChildrenList(Human human) {
        if (!(human.equals(null)) ){
            this.сhildrenList.add(human);
        }
    }

    public String getInfo(){
        return String.format("\n\nФамилия: %s;\nИмя: %s;\nПол: %s;\nДата рождения: %s;", family, name, gender,birthdate);
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
