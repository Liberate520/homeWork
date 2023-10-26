package person;
import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import tree.FamilyTree;

public class Person implements Serializable{
    private int id;
    private FamilyTree family;
    private String lastname;
    private String name;

    private LocalDate birthday;
    private LocalDate deathday;
    private Gender gender;
    private Map<String, String> parents;
    private List<Person> children;
    private Person spouse;

    public Person(FamilyTree family, String lastname, String name, Gender gender) {
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        Map<String, String> parents = new HashMap<>();
        this.parents = parents;
        List<Person> children = new ArrayList<>();
        this.children = children;
        this.family = family;
        family.addMember(this);
    }

    public Person(String name, Gender gender, LocalDate birthDay) {
    }

    public String getAgeString() {
        if (this.deathday == null) {
            return Integer.toString(Period.between(this.birthday, LocalDate.now()).getYears());
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(this.lastname);
            stringBuilder.append("; ").append(this.name).append(" умер(-ла) в возрасте ");
            stringBuilder.append(Period.between(this.birthday, this.deathday).getYears());
            stringBuilder.append(" лет.");
            return stringBuilder.toString();
        }
    }

    public Integer getAgeInt() {
        if (this.deathday == null) {
            Integer result = Period.between(this.birthday, LocalDate.now()).getYears();
            return result;
        }
        else {
            Integer result = Period.between(this.birthday, this.deathday).getYears();
            return result;
        }
    }

    public String getId() {
        StringBuilder stringBuilder = new StringBuilder("Id: ");
        stringBuilder.append(this.id+"; ");
        return stringBuilder.toString();
    }

    public Integer getIntId() {return id;}

    public String getLastname() { return lastname; }

    public String getName() { return name; }

    public String getNameAndLastName() { 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name+" "+this.lastname+"; ");
        return stringBuilder.toString(); 
    }

    public LocalDate getBirthday() { return birthday; }

    public LocalDate getDeathday() { return deathday; }

    public Gender getGender() { return gender; }

    public String getParents() {
        StringBuilder stringBuilder = new StringBuilder("Родители: ");
        if (this.parents.isEmpty()){
            stringBuilder.append("Неизвестны; ");
            }
        else{
            stringBuilder.append(this.parents+"; ");
        }
            return stringBuilder.toString();
    }

    public String getChildren() {
        if(this.children.isEmpty()){
            return "Детей нет;";
        }
        StringBuilder stringBuilder = new StringBuilder("Дети: ");
        stringBuilder.append(this.children+"; ");
        return stringBuilder.toString();
    }

    public String getSpouse() {
        if(this.spouse == null){
           return "Не женат(-а); ";
        }
        StringBuilder stringBuilder = new StringBuilder("Супруг(-а): ");
        stringBuilder.append(this.spouse+"; ");
        return stringBuilder.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDeathday(LocalDate deathday) {
        this.deathday = deathday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private void setParent(Person human) {
        if (human.gender == Gender.Male) {
            this.parents.put("Отец "," "+human.getNameAndLastName());
        }
        else this.parents.put("Мать "," "+human.getNameAndLastName());
    }

    public void setChild(Person human) {
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    @Override
    public String toString() {
        return "Фамилия: " + lastname + ", имя: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Person)){
            return false;
        }
        Person human = (Person) obj;
        return family == human.family && lastname.equals(human.getLastname()) && name.equals(human.getName()) && gender.equals(human.gender);
    }

    @Override
    public int hashCode() {
        return 3 * family.hashCode() + 7 * lastname.hashCode() + 13 * name.hashCode() + 24 * gender.hashCode();
    }
}

