package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private long id;
    private String name;
    private Gender gender;
    private Human mother, father;
    private List<Human> child;
    private final LocalDate birthDay;
    private LocalDate deathDay;


    public Human(String name, Gender gender, LocalDate birthDay) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.mother = null;
        this.father = null;
        this.birthDay = birthDay;
        this.deathDay = null;
        child = new ArrayList<>();
    }

    public Human(String name, Gender gender,Human mother,Human father, LocalDate birthDay) {
        this.gender = gender;
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.birthDay = birthDay;
        child = new ArrayList<>();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }



    public String getChild() {
        StringBuilder sb = new StringBuilder();
        for (Human human:child) {
            sb.append(human.getName() + " " + human.getAge() + " ");
            if(human.gender.equals(Gender.Mail)){
                sb.append("Мужчина" + "\n");
            } else {
                sb.append("Женщина" + "\n");
            }
        }
        return sb.toString();
    }

    public void setChild(List<Human> child) {
        this.child = child;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name).append(" ");
        sb.append("Возраст : ");
        sb.append(getAge()).append(" ");
        sb.append("\n");
        if(!(child.isEmpty())){
            for (Human human : child) {
                sb.append(human.getName() +" Дата рождения: " + human.getBirthDay() + "\n");
            }

        }
        return sb.toString();
    }

    public boolean addChildren(Human children){
        if(!child.contains(children)) {
            child.add(children);
            return true;
        }
        return false;
    }

//    public boolean addParants(Human parents){
//        if(parents.getGender().equals(Gender.Mail)){
//            setFather(parents);
//        } else {
//            setMother(parents);
//        }
//        return true;
//    }

    private int getPeriod(LocalDate birthDay,LocalDate deathDay){
        Period diff = Period.between(birthDay,deathDay);
        return diff.getYears();
    }

    public int getAge(){
        if(deathDay == null){
            return getPeriod(birthDay,LocalDate.now());
        } else {
            return getPeriod(birthDay,deathDay);
        }
    }
}
