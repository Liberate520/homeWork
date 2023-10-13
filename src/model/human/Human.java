package model.human;

import java.io.Serializable;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import model.famailyTree.TreeNode;

 
public class Human implements Serializable, TreeNode<Human> {
   private long id;
   private String name;
   private String fistName;
   private String lastName;
   private Gender gender;
   private Human mother;
   private Human father;
   private List<Human> parents;
   private List<Human> children;
   private LocalDate birthDate;
   private LocalDate deathDate;
   private Human spouse;

   public Human(String name, String fistName, String lastName, LocalDate birthDate, LocalDate deathDate, Gender gender, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.fistName = fistName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }

        children = new ArrayList<>();
    }

    public Human(String name, String fistName, String lastName, LocalDate birthDate, Gender gender, Human mother, Human father) {
        this(name, fistName, lastName, birthDate, null, gender, mother, father);
    }

    public Human(String name, String fistName, String lastName, LocalDate birthDate, Gender gender) {
        this(name, fistName, lastName, birthDate, null, gender, null, null);
    }

    public Human(String name, String fistName, String lastName, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(name, fistName, lastName, birthDate, deathDate, gender, null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    
    
    public boolean addParent(Human parent) {
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather() {
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }   
    
    public Human getMother() {
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public String getName(){
        return name;
    }

    

    

    public String getMotherInfo() {
        String res = " Мама: ";
        if (mother != null) {
            res += mother.getFistName() + " " + mother.getLastName();
        } else {
            res += "Нет";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = " Папа: ";
        if (father != null) {
            res += father.getFistName() + " " + father.getLastName();
        } else {
            res += "Нет";
        }
        return res;
    }


    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }

    public Human getSpouse(){
        return spouse;
    }


    public String toString() {
        return info();
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(" Имя: ").append(fistName);
        sb.append(" Фамилия: ").append(lastName);
        sb.append(" Пол: ").append(gender);
        sb.append(" День рожд: ").append(birthDate);
        sb.append(" Дата смерти: ").append(deathDate);
        sb.append(getMotherInfo()).append(" ");
        sb.append(getFatherInfo()).append(" ");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }


    

    public void setMother(Human mother) {
        this.mother = mother;
    }

    
    public void setFather(Human father) {
        this.father = father;
    }

    public Gender getGender() {
        return gender;
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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int compareTo(Human o){
        return fistName.compareTo(o.getFistName());
    }
}
    





