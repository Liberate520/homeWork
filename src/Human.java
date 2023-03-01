package src;

import java.io.Serializable;
import java.util.*;

public class Human extends It implements Serializable {
    private Human father;
    private Human mother;
    private List<Human> children;

    private String gender;
    private String dateOfBorn;

    private String dateOfDeath;
    private String placeOfBirth;
    private String firstName;
    private String patronymic;
    private String lastName;
    private final int id;


    public Human(Human father, Human mother, List<Human> children, String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        id = Stat.getId();
        Validation valid = new Validation();
        this.father = father;
        this.mother = mother;
        this.children = Objects.requireNonNullElseGet(children, ArrayList::new);
        if (valid.isValidGender(gender)) {
            this.gender = gender;
        }
        this.dateOfBorn = "";
        this.dateOfDeath = "";
        if (valid.isDateValid(dateOfBorn, false)) {
            this.dateOfBorn = dateOfBorn;
        } else {
            this.dateOfBorn = "01.01.0000";
        }
        if (valid.isDateValid(dateOfDeath, true)) {
//            this.dateOfDeath = Objects.requireNonNullElse(dateOfDeath, "");
            this.dateOfDeath = dateOfDeath;
        }
        this.placeOfBirth = placeOfBirth;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.lastName = lastName;
    }

    public Human() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public Human(Human father, Human mother, String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        this(father, mother, null, gender, dateOfBorn, dateOfDeath, placeOfBirth, firstName, patronymic, lastName);
    }

    public Human(String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        this(null, null, null, gender, dateOfBorn, dateOfDeath, placeOfBirth, firstName, patronymic, lastName);
    }

    @Override
    public int getId() {
        return id;
    }

    public boolean isAlive() {
        return dateOfDeath.isEmpty();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<It> getChildren() {
        return new ArrayList<>(children);
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getDateOfBorn() {
        return dateOfBorn;
    }

    public void setDateOfBorn(String dateOfBorn) {
        this.dateOfBorn = dateOfBorn;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void addChild(Human human) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(human);
        if(Objects.equals(this.getGender(), "Male")){
            human.setFather(this);
        }
        if(Objects.equals(this.getGender(), "Female")){
            human.setMother(this);
        }
    }


    public int getAge() {
        Dates dates = new Dates();
        return dates.getAge(getDateOfBorn(), getDateOfDeath());
    }

    public Human createUnit() {
        HumanFactory human = new HumanFactory();
        return human.creteHuman();
    }
    @Override
    public String getShortName(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lastName).append(" ").append(firstName.charAt(0)).append(".");
        stringBuilder.append(patronymic.charAt(0)).append(".");
        return stringBuilder.toString();
    }


    @Override
    public String toString() {
        return "ID: " + id +
                ", Пол='" + gender + '\'' +
                ", ДР='" + dateOfBorn + '\'' +
                ", ДС='" + dateOfDeath + '\'' +
                ", Место рождения='" + placeOfBirth + '\'' +
                ", Имя='" + firstName + '\'' +
                ", Отчество='" + patronymic + '\'' +
                ", Фамилия='" + lastName + '\'';
    }
}

