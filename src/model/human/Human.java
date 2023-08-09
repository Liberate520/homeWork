package model.human;

import model.genealogicalTree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Human implements Serializable, Comparable<Human>, TreeNode {

    private int idPerson;
    private String name;
    private String lastName;
    Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;


    public Human(String name, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father, Human spouse, List<Human> children) {
        this.idPerson = -1;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.children = new ArrayList<>();
    }

    public Human(String name, String lastName, Gender gender){
        this(name, lastName, gender, null, null, null, null, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(idPerson, ((Human) o).idPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPerson);
    }

    @Override
    public String toString() {
        return getInfo();
    }


    public String getLastName(){
        return this.lastName;
    }

    public int getID(){
        return this.idPerson;
    }

    @Override
    public void setSpouse(Human human) {
        this.spouse = human;
    }

    public void setID(int id){idPerson=id;}
    public String getName(){
        return this.name;
    }


    public LocalDate getBirth(){
        return this.birthDate;
    }

    public Gender getGender(){return this.gender;}


    public void addMother(Human human){
        this.mother = human;
    }

    public void addFather(Human human){
        this.father = human;
    }



    public void getChildren(){
        if(!this.children.isEmpty()){
            for (Human human:this.children
            ) {
                System.out.println(human);
            }
        }else System.out.println("This person doesn't have any children!");
    }

    public boolean checkDead(Human human){
        return human.deathDate!= null;
    }

    public int showAge(){
        if(!checkDead(this)){
            LocalDate today = LocalDate.now();
            Period intervalPeriod = Period.between(this.birthDate, today);
            return intervalPeriod.getYears();
        }else{
            Period intervalPeriod = Period.between(this.birthDate, this.deathDate);
            return intervalPeriod.getYears();
        }
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID:");
        sb.append(this.idPerson);
        sb.append("/");
        sb.append("Name:");
        sb.append(this.name);
        sb.append("/");
        sb.append("Last name:");
        sb.append(this.lastName);
        sb.append("/");
        sb.append("Gender:");
        sb.append(this.gender);
        sb.append("/");
        sb.append("Birth date:");
        sb.append(this.birthDate);
        sb.append("/");
        if(deathDate!=null){
            sb.append("Death date:");
            sb.append(this.deathDate);
            sb.append("/");
        }


        if(this.mother !=null) {
            sb.append("Mother:");
            sb.append(this.mother.name);
            sb.append(" ");
            sb.append(this.mother.lastName);
            sb.append("/");
        }


        if(this.father !=null) {
            sb.append("Father:");
            sb.append(this.father.name);
            sb.append(" ");
            sb.append(this.father.lastName);
            sb.append("/");
        }

        sb.append("Spouse:");
        if(this.spouse !=null) {
            sb.append(this.spouse.name);
            sb.append(" ");
            sb.append(this.spouse.lastName);
        }else sb.append("Absent");
        sb.append("/");
        sb.append("Children:");
        if(this.children.size()!=0){

            for (Human human: this.children
            ) {
                sb.append(human.name);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
        }else sb.append("Absent");
        return sb.toString();
    }

    @Override
    public int compareTo(Human o) {
        if(this.idPerson > o.idPerson) return 1;
        else if (idPerson < o.idPerson) {
            return -1;
        }else return 0;
    }
    public void setChild(Human child) {
        if(!this.children.contains(child)) {
            this.children.add(child);
        }
    }
}



