package Human;

import java.io.Serializable;
import java.security.PublicKey;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private LocalDate deathday;
    private Human spouse;
    private Map<String, Human> parents;
    private List<Human> children;


    public Human(String name, LocalDate birthday, LocalDate deathday, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.deathday = deathday;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new HashMap<>();
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


    public void setChildren(List<Human> children) {
        this.children = children;
    }

    private void setParent(Human human) {
        if (human.gender == Gender.Female) {
            this.parents.put("\nмать",human);
        }
        else this.parents.put("\nотец",human);
    }

    public void setSpouse(Human spouse){
        this.spouse = spouse;
        spouse.spouse = this;
    }

    public void setChild(Human human) {
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
            if (this.spouse != null){
                this.spouse.setChild(human);
            }
        }
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public LocalDate getDeathday() {
        return deathday;
    }
    public int getAge(){
        if (deathday == null){
            return getPeriod(birthday,LocalDate.now());
        }
        else {
            return getPeriod(birthday, deathday);
        }
    }

    private int getPeriod(LocalDate birthday, LocalDate deathday){
        Period diff =  Period.between(birthday,deathday);
        return diff.getYears();
    }
    public String getSpouse() {
        StringBuilder stringBuilder = new StringBuilder("\nСупруг(а): ");
        stringBuilder.append(this.spouse);
        return stringBuilder.toString();
    }

    public Gender getGender() {
        return gender;
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder("\nДети: ");
        stringBuilder.append(this.children);
        return stringBuilder.toString();
    }
    public  String getParensts(){
        StringBuilder stringBuilder = new StringBuilder("\nРодители: ");
        stringBuilder.append(this.parents);
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return " " + name; // Для лучшей читаемости только имена
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return Objects.equals(name, human.name) && Objects.equals(birthday, human.birthday) && gender == human.gender;
    }
}