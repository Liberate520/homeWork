package home_work_class;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human {
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
        StringBuilder stringBuilder = new StringBuilder();
        for (Human childern: childrenList) {
            stringBuilder.append(showHuman(childern));
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    private Human(String name, Gender gender, LocalDate bornDate, LocalDate diedDate, Human mother, Human father) {
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

    private String showHuman(Human human){
        if(human != null){
            return human.getName() + ", возраст " + Integer.toString(human.ageHuman());
        }
        return "";
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
        stringBuilder.append(getName());
        stringBuilder.append(" ");
        stringBuilder.append(getGender());
        stringBuilder.append(", возраст ");
        stringBuilder.append(Integer.toString(this.ageHuman()));
        stringBuilder.append("\n");
        stringBuilder.append("мать: ");
        stringBuilder.append(showHuman(this.mother));
        stringBuilder.append(" отец: ");
        stringBuilder.append(showHuman(this.father));
        stringBuilder.append("\n");
        stringBuilder.append("дети: ");
        stringBuilder.append(showChildren());
        return stringBuilder.toString();
    }

    public void addChildren(Human human){
        human.setParens(this);
        this.childrenList.add(human);
    }
}
