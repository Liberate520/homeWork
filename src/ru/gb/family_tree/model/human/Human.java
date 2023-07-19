package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.tree.TreeItem;

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

    public Human(String name, Gender gender, LocalDate birthday) {
    }

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
//        this.secondSurname = secondSurname;
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

    public Human(String numPassport, String surname, String name, Gender gender, LocalDate birthday,
                    Human mother, Human father) {
        this(numPassport, surname, name, gender, birthday, null, mother, father);
    }
    public Human(String numPassport, String surname, String name, Gender gender, LocalDate birthday,
                    LocalDate dateOfDeath) {
        this(numPassport, surname, name, gender, birthday, dateOfDeath, null, null);
    }
    public Human(String numPassport, String surname, String name, Gender gender, LocalDate birthday) {
        this(numPassport, surname, name, gender, birthday, null, null, null);
    }

    public Human() { }

    public int getId() {return id;}
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

    @Override
    public void addKid(Object human) {}
    @Override
    public void addParent(Object human) {}
    @Override
    public void addPartner(Object human) {
    }

    public List<Human> getKids() {
        return kids;
    }
    public void addKid(Human kid) {
        if (!kids.contains(kid)) {  // имя не повторяется
            kids.add(kid);
        } else {
            System.out.println("не добавлен! такой ребенок уже есть!");
        }
    }
    public List<Human> getPartner() { return partners;}
    public void addPartner(Human partner) {
        if (!partners.contains(partner)) {
            partners.add(partner);
        }
    }
    public List<Human> getParents() {
        return parents;
    }
    public void addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
        }
    }

    public Human getFather() {
        for (Human parent : parents) {
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

//    public Human getWedding(Human human) {
//        for(Human parent: parents){
//            if(){
//                return parent;
//            }
//        }
//        return null;
//    }

    @Override
    public String toString() {// переопределяем иначе будет петля рекурсии из-за вложений в виде объектов Human
        return getInfoHuman();
    }

    public String getInfoHuman() {
        String sb = " id:" + id +
                ", passport: " + numPassport + ", " +
                " " + surname + " " +
//                "(" + secondSurname + ")" +
                name +
                ", " + gender +
                ", возраст: " + getAge() +
                " (birthday: " + birthday +
                ", dateOfDeath: " + dateOfDeath+ "),\n" +
                getPartnerInfo() +"\n"+
                getMotherInfo()+"\n" +
                getFatherInfo()+"\n" +
                getKidInfo()+"\n";
        return sb;
    }

    public String getMotherInfo() {
        String result = "   mother: ";
        if (getMother() != null) {
            result += "id="+ getMother().getId() + ", " + getMother().getSurname() + " " + getMother().getName();
        } else {
            result += "unknown";
        }
        return result;
    }

    public String getPartnerInfo() {
        String result = "   partner: ";
        if (getPartner() != null) {
            result += getPartner();
        } else {
            result += "unknown";
        }
        return result;
    }

    public String getKidInfo() {
        StringBuilder result = new StringBuilder();
        result.append("  kids: ");
        if (kids.size() != 0) {
            result.append(kids.get(0).getSurname() + " " + kids.get(0).getName());
            for (Human kid : kids) {
                result.append(" , id="+ kid.getId() + ", возраст " + kid.getAge()).append(" ");
            }
        } else {
            result.append("отсутствуют");
        }
        return result.toString();
    }

    public String getFatherInfo() {
        String result = "   father: ";
        if (getMother() != null) {
            result += "id="+ getFather().getId() + ", "+ getFather().getSurname() + " " + getFather().getName();
        } else {
            result += "unknown";
        }
        return result;
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
        return human.getNumPassport().equals(getNumPassport());  // сущности равны если одинаковы номера паспортов
    }
}