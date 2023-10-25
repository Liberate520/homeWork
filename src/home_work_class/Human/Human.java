package home_work_class.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private LocalDate bornDate;
    private LocalDate diedDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> childrenList;

    public int ageHuman(){
        int curYear = LocalDate.now().getYear();
        if (this.bornDate == null){
            return 0;
        }
        if (this.diedDate != null){
            return diedDate.getYear() - bornDate.getYear();
        }

        return curYear - bornDate.getYear();
    }

    public String showChildren(){
        if (childrenList.isEmpty()){ return "---"; }
        StringBuilder stringBuilder = new StringBuilder();
        for (Human childern: childrenList) {
            stringBuilder.append(showHuman(childern));
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    private Human(String name, Gender gender, LocalDate bornDate, LocalDate diedDate, Human mother, Human father) {
        this.id = hashCode();
        this.name = name;
        this.bornDate = bornDate;
        this.diedDate = diedDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.childrenList = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate bornDate, LocalDate diedDate){
        this(name, gender, bornDate, diedDate, null, null);
    }
    public Human(String name, Gender gender, LocalDate bornDate){
        this(name, gender, bornDate, null, null, null);
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getBornDate() {
        return this.bornDate;
    }

    public LocalDate getDiedDate() {
        return this.diedDate;
    }

    public String getGender() {
        if (this.gender == Gender.Male) {return "муж.";}
        return "жен.";
    }
    public int getId(){ return this.id; }

    private String showHuman(Human human){
        StringBuilder stringBuilder = new StringBuilder();
        if(human != null){
            stringBuilder.append(human.getName());
            stringBuilder.append(", возраст ");
            stringBuilder.append(Integer.toString(human.ageHuman()));
            return stringBuilder.toString();
        }
        return "---";
    }

    public String getMother() {
        return showHuman(this.mother);
    }

    public String getFather() {
       return showHuman(this.father);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public void setDiedDate(LocalDate diedDate) {
        this.diedDate = diedDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setParens(Human human) {
        if (human.gender == Gender.Male)
            {this.father = human;}
        else
            {this.mother = human;}
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(showHuman(this));
        stringBuilder.append(", ");
        stringBuilder.append(getGender());
        stringBuilder.append("\n");
        stringBuilder.append("мать: ");
        stringBuilder.append(showHuman(this.mother));
        stringBuilder.append(", отец: ");
        stringBuilder.append(showHuman(this.father));
        stringBuilder.append("\n");
        stringBuilder.append("дети: ");
        stringBuilder.append(showChildren());
        return stringBuilder.toString();
    }

    public void addChildren(Human human){
        human.setParens(this);
        if (! childrenList.contains(human))
            {this.childrenList.add(human);}
    }

    public List<Human> getParens(){
        List<Human> parensList = new ArrayList<>();
        if (this.father != null){parensList.add(this.father);}
        if (this.mother != null) {parensList.add(this.mother);}

        return parensList;
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }
}
