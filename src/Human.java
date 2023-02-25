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
        if (valid.isDateValid(dateOfBorn, false)) {
            this.dateOfBorn = dateOfBorn;
        } else {
            this.dateOfBorn = "01.01.0000";
        }
        if (valid.isDateValid(dateOfDeath, true)) {
            this.dateOfDeath = Objects.requireNonNullElse(dateOfDeath, "");
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

    public void createUnit() {
        Validation validation = new Validation();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите пол Male/Female: ");
        String gender = scanner.next();
        if (validation.isValidGender(gender)) {
            this.gender = gender;
        }
        System.out.print("Укажите дату рождения в формате dd.mm.YYYY: ");
        String dateOfBorn = scanner.next();
        if (validation.isDateValid(dateOfBorn, false)) {
            this.dateOfBorn = dateOfBorn;
        }
        System.out.print("Укажите дату смерти в формате dd.mm.YYYY(или укажите 0): ");
        String dateOfDeath = scanner.next();
        if (validation.isDateValid(dateOfDeath, false)) {
            this.dateOfDeath = dateOfDeath;
        }
        System.out.print("Укажите место рождения: ");
        this.placeOfBirth = scanner.next();
        System.out.print("Укажите имя: ");
        this.firstName = scanner.next();
        System.out.print("Укажите отчество: ");
        this.patronymic = scanner.next();
        System.out.print("Укажите фамилию: ");
        this.lastName = scanner.next();
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
//    }
}

