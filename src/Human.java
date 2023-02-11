package src;

import java.util.*;

public class Human {
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();

    private String gender;
    private String dateOfBorn;

    private String dateOfDeath;
    private String placeOfBirth;
    private String firstName;
    private String patronymic;
    private String lastName;


    public Human(Human father, Human mother, List<Human> children, String gender, String dateOfBorn, String dateOfDeath, String placeOfBirth, String firstName, String patronymic, String lastName) {
        Validation valid = new Validation();
        this.father = father;
        this.mother = mother;
        this.children = Objects.requireNonNullElseGet(children, ArrayList::new);
        if (valid.isValidGender(gender)) {
            this.gender = gender;
        }
        if (valid.isDateValid(dateOfBorn, false)) {
            this.dateOfBorn = dateOfBorn;
        }
        if (valid.isDateValid(dateOfDeath, true)) {
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

    public List<Human> getChildren() {
        return children;
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
    }


    public int getAge() {
        Dates dates = new Dates();
        HashMap<String, Integer> firstDate = dates.parseDate(dateOfBorn);
        HashMap<String, Integer> secondDate;
        if (isAlive()) {
            secondDate = dates.parseDate(dates.getTodayDate());
        } else {
            secondDate = dates.parseDate(dateOfDeath);
        }
        if (secondDate.get("month") - firstDate.get("month") < 0) {
            return secondDate.get("year") - firstDate.get("year") - 1;
        } else {
            return secondDate.get("year") - firstDate.get("year");
        }
    }

    @Override
    public String toString() {
        return "src.Human{" +
                ", gender='" + gender + '\'' +
                ", dateOfBorn='" + dateOfBorn + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
//    }
}

