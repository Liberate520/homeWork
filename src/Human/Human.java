package Human;

import java.time.LocalDate;
import java.util.*;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthday;
    private Human spouse;
    private Map<String, Human> parents;
    private List<Human> children;
    private Human grandMother; //Не реализовано
    private Human grandFather;//Не реализовано
    private List<Human> brotherAndSister; //Не реализовано
    private Human cousins;//Не реализовано
    private Human uncle;//Не реализовано
    private Human aunt; //Не реализовано

    public Human(String name, LocalDate birthday, Gender gender) {
        this.name = name;
        this.birthday = birthday; // просто дата рождения без даты смерти. Могу реализовать, но хочу спать :D
        this.gender = gender;
        this.children = new ArrayList<>();
        this.brotherAndSister = new ArrayList<>();
        this.parents = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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
    public void setGrandMother(Human grandMother) {
        this.grandMother = grandMother;
    } //Не реализовано

    public void setGrandFather(Human grandFather) {
        this.grandFather = grandFather;
    } //Не реализовано

    public void setBrotherAndSister(List<Human> brotherAndSister) { //Не реализовано
        this.brotherAndSister = brotherAndSister;
    }

    public void setCousins(Human cousins) {
        this.cousins = cousins;
    } //Не реализовано

    public void setUncle(Human uncle) {
        this.uncle = uncle;
    } //Не реализовано

    public void setAunt(Human aunt) {
        this.aunt = aunt;
    } //Не реализовано

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
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

    public Human getGrandMother() {
        return grandMother;
    }

    public Human getGrandFather() {
        return grandFather;
    }

    public String getBrotherAndSister() {
        StringBuilder stringBuilder = new StringBuilder("\nБратья и сёстры: ");
        stringBuilder.append(brotherAndSister);
        return stringBuilder.toString();
    }

    public Human getCousins() {
        return cousins;
    }

    public Human getUncle() {
        return uncle;
    }

    public Human getAunt() {
        return aunt;
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