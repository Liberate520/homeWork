package ru.gb.family_tree.Family;

import ru.gb.family_tree.Saveble;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Saveble, Serializable{
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private List<Human> children;
    private Human spouse;
    private Human mother, father;

    public void save() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("text.txt"));
        os.writeObject(this);
        os.close();
    }
    public Human read() throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("text.txt"));
        Human human = (Human) is.readObject();
        is.close();
        return human;
    }

    public Human(String name, Gender gender,
                 LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender,LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate dateOfBirth, Human mother, Human father) {
        this(name, gender, dateOfBirth, null, mother, father);
    }
    public Human(String name, Gender gender,LocalDate dateOfBirth,LocalDate dateOfDeath) {
        this(name, gender, dateOfBirth, dateOfDeath, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public void addParent(Human parent) {
        if(parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }

    public int getAge(){
        if(dateOfDeath == null) {
            return getPeriod(dateOfBirth, LocalDate.now());
        } else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }
    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath) {
        Period time = Period.between(dateOfBirth, dateOfDeath);
        return time.getYears();
    }
    public String getSpouseInfo() {
        String res = "Супруг: ";
        if(spouse == null) {
            res += "Нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if(mother == null) {
            res += "Нет";
        } else {
            res += mother.getName();
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if(father == null) {
            res += "Нет";
        } else {
            res += father.getName();
        }
        return res;
    }
    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }  else {
            res.append("Нет");
        }
        return res.toString();
    }
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    public Human getSpouse() {
        return spouse;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath(){
        return dateOfDeath;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", Имя: ");
        sb.append(name);
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", Дата рождения: ");
        sb.append(dateOfBirth);
        sb.append(", Возраст: ");
        sb.append(getAge());
        sb.append(", Дата смерти: ");
        sb.append(dateOfDeath);
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}

        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }



}