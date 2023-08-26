package human;
import humanGroup.HumanGroupItem;
import relative.Relative;
import tree.Tree;

import java.time.LocalDate;
import java.time.Period;

public class Human implements Comparable<Human>, HumanGroupItem, Tree {
    private String fullName;
    private human.Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;

    public Human(String fullName, Gender gender, LocalDate birthDate,LocalDate deathDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;

    }

    public Human(String fullName, Gender gender, LocalDate birthDate) {
        this(fullName, gender, birthDate, null);
    }


    @Override
    public String toString() {
        return  "Имя =" + getFullName()+ '\'' +
                ", пол =" + getGender() +
                ", возраст =" + getAge() +
                '}';
    }



    public String getFullName() { return fullName; }

    @Override
    public Object getPerson1() {
        return null;
    }

    @Override
    public Object getPerson2() {
        return null;
    }

    @Override
    public Relative getRe() {
        return null;
    }

    public human.Gender getGender() {
        return gender;

    }
    public LocalDate getBirthDate() {
        return birthDate;
    }



    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" имя: ");
        sb.append(getFullName());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(" если он(а) является ");
        return sb.toString();
    }


    @Override
    public int compareTo(Human o) {
        return fullName.compareTo(o.fullName);
    }
}

