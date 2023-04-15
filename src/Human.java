import java.util.*;

public class Human {
    public String name;
    private Map<String, Integer> date_of_birth = new HashMap<>();
    private Integer day;
    private Integer month;
    private Integer year;
    private Gender gender;
    private ArrayList<Human> children;
    private Human father;
    private Human mother;
    private Human In_marriage_with;

    public Human(String name, Integer day, Integer month, Integer year, Gender gender,
                 Human father, Human mother, Human Human) {
        this.children = new ArrayList<>();
        this.name = name;
        this.gender = gender;
        this.date_of_birth.put("day", day);
        this.date_of_birth.put("month", month);
        this.date_of_birth.put("year", year);
        this.father = father;
        this.mother = mother;
        this.In_marriage_with = Human;
    }


    public Human(String name, Integer day, Integer month, Integer year, Gender gender) {
        this(name, day, month, year, gender, null, null, null);
    }

    public Human(String name, Integer day, Integer month, Integer year, Gender gender, Human human) {
        this(name, day, month, year, gender, null, null, human);
    }

    public Human(String name, Integer day, Integer month, Integer year, Gender gender, Human father, Human mother) {
        this(name, day, month, year, gender, father, mother, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Map<String, Integer> date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
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

    public Human getIn_marriage_with() {
        return In_marriage_with;
    }

    public void setIn_marriage_with(Human in_marriage_with) {
        In_marriage_with = in_marriage_with;
    }

    @Override
    public String toString() {
        return name +" "+ date_of_birth;
    }
}