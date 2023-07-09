package ru.gb.family_tree.Human;

import ru.gb.family_tree.Servise.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeItem {
    private int id;
    private String numPassport;
    private String surname;
    private String name;
    private String secondSurname;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate dateOfDeath;
    private List<Human> partners;
    private List<Human> parents;
    private List<Human> kids;

    public enum Gender {
        Male, Female
    }

    //    public enum Partner{
//        husband, wife
//    }
    public Human(String numPassport, String surname, String name, Gender gender, LocalDate birthday, LocalDate dateOfDeath, Human mother, Human father) {
        this.id = id;
        this.numPassport = numPassport;
        this.surname = surname;
        this.name = name;
        this.secondSurname = secondSurname;
        this.gender = gender;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        partners = new ArrayList<>();
        parents = new ArrayList<>();
        if (father != null || mother != null) {
            parents.add(father);
            parents.add(mother);
        }
        kids = new ArrayList<>();
    }
    //TODO добавление партнера

    public Human(String numPassport, String surname, String name, Gender gender, LocalDate birthday,
                    Human mother, Human father) {
        this(numPassport, surname, name, gender, birthday, null, mother, father);
    }

    public Human(String numPassport, String surname, String name, Gender gender, LocalDate birthday,
                    LocalDate dateOfDeath) {
        this(numPassport, surname, name, gender, birthday, dateOfDeath, null, null);
    }

    public Human() {
    }

    ;

    public void setId(int id) {
        this.id = id;
    }

    public String getNumPassport() {
        return numPassport;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Human getPartner() {
        return (Human) partners;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getKids() {
        return kids;
    }

    public void addKid(Human kid) {
        if (!kids.contains(kid)) {  // имя не повторяется
            kids.add(kid);
        } else {
            System.out.println("не добален! такой ребенок уже есть!");
        }
    }

    public void addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public Human getFather() {
        for (Human parent : parents) {
//            if(parent.getGender() == Gender.Male && parent.getSecondSurname() == null){
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
//            if(parent.getGender() == Gender.Female && parent.getSecondSurname() != null){
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public Human getWedding(Human human) {
//        for(Human parent: parents){
//            if(){
//                return parent;
//            }
//        }
        return null;
    }


    @Override
    public String toString() {
        return getInfoHuman();
    } // переопределяем (иначе будет петля рекурсии из-за вложений в виде объектов Human)

    public String getInfoHuman() {
        String sb = "id:" + id +
                ", passport: " + numPassport +
                " " + surname + " " +
//                "(" + secondSurname + ")" +
                name +
                ", " + gender +
                ", возраст: " + getAge() +
                " (birthday: " + birthday +
                ", dateOfDeath: " + dateOfDeath +
                "), " +
//                "\n\t partner: '" + partner +
                getMotherInfo() +
                getFatherInfo() +
                ", kids: " + kids + ";";
        return sb;
    }

    public String getMotherInfo() {
        String result = "mother: ";
        if (getMother() != null) {
            result += getMother().getSurname() + " " + getMother().getName();
        } else {
            result += "unknown";
        }
        return result;
    }

    public String getFatherInfo() {
        String result = ", father: ";
        if (getMother() != null) {
            result += getFather().getSurname() + " " + getFather().getName();
        } else {
            result += "unknown";
        }
        return result;
    }

    public String getKidInfo() {
        StringBuilder result = new StringBuilder();
        result.append("kids: ");
        if (kids.size() != 0) {
            result.append(kids.get(0).getName());
            for (Human kid : kids) {
                result.append(kid).append(" ");
            }
        } else {
            result.append("missing kids");
        }
        return result.toString();
    }

    @Override
    public int getAge() {
        if (dateOfDeath != null) {
//            return getPeriod(birthday, dateOfDeath);
            return getPeriod(birthday, dateOfDeath);
        } else {
            return getPeriod(birthday, LocalDate.now());
        }
    }

    private int getPeriod(LocalDate birthday, LocalDate dateOfDeath) {
        Period diff = Period.between(birthday, dateOfDeath);
        return diff.getYears();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Human human)) return false;
        return human.getNumPassport().equals(getNumPassport());
    }
//    @Override
//    public int compareTo(Human o) {  // для работы sortByName FamilyTree
//        return name.compareTo(o.name);
//    }
}

