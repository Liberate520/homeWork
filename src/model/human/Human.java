package model.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public class Human implements Serializable, NodeTree<Human>{
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(int id, String name, LocalDate birthDate, LocalDate deathDate, 
    Gender gender, Human mom, Human dad, List<Human> childrens) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mom;
        this.father = dad;
        this.childrens = childrens;
    }

    public Human() {
        this(0, null, null, null, null, null, null, null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("\n").append(id).append(", имя: ").append((name)).append(", дата рождения: ").append(birthDate);
        if (deathDate == null)
            sb = sb.append(", возраст: ").append(getAge());
        else
            sb = sb.append(", дата смерти: ").append(deathDate);
        if (mother == null)
            sb = sb.append(", мать не определена");
        else
            sb = sb.append(", мать: ").append(mother.getName());
        if (father == null)
            sb = sb.append(", отец не определен");
        else
            sb = sb.append(", отец: ").append(father.getName());
        if (childrens == null)
            sb = sb.append(", детей нет");
        else {
            sb = sb.append(", дети:");
            for (int i = 0; i < childrens.size(); i++) {
                sb = sb.append(" ").append(childrens.get(i).getName());
            }
        }

        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id=id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAge() {
        LocalDate currenDate = LocalDate.now();
        if (getDeathDate() == null)
            return Period.between(birthDate, currenDate).getYears();
        else
            return Period.between(birthDate, deathDate).getYears();
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Human> childrens) {
        this.childrens = childrens;
    }

    public void addChild(Human human) {
        if (this.childrens == null)
            this.childrens = new ArrayList<>();
        this.childrens.add(human);
    }
}