package human;
//package human.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String surname, name, patronymic;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human father, mother;
    private List<Human> children;
    //    private String placeOfBirth;
    //    private String location;
    private int id;
    private String fullName;

    public Human(){}

    public Human(String surname, String name, String patronymic, Gender gender, LocalDate birthDate,
                 LocalDate deathDate, Human father, Human mother, List<Human> children, int id) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        this.id = id;
    }

//    public Human(String surname, String name, String patronymic, Human father, Human mother, List<Human> children) {
//        this(surname, name, patronymic, null, null, null, father, mother, children, 0);
//    }

    // Getting
    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public Gender getGender() {
        return gender;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public LocalDate getDeathDate() {
        return deathDate;
    }
    public Human getFather() {
        return father;
    }
    public Human getMother() {
        return mother;
    }
    public List<Human> getChildren() {
        return children;
    }
    public int getId() {
        return id;
    }

    // Setting
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public void setId(int id) {
        this.id = id;
    }

    //
    public String getFullName() {
        return getSurname() + " " + getName() + getPatronymic();
    }

    public void addChildren(Human human) {
        children.add(human);
    }


//    public Human(String surname, String name, String patronymic, Gender gender) {
//        this(surname, name, patronymic, gender, null, null);
//    }

    // public Human(String surname, String name, String patronymic, Human father, Human mother) {
    //     this(surname, name, patronymic, father, mother);
    // }


    @Override
    public String toString() {
        return surname + " " + name + patronymic +// fullName +
                ", пол: " + gender +
                ", Дата Рождения: " + birthDate +
                ", Дата Смерти: " + deathDate +
                ", Отец: " + ((getFather() == null )? "нет данных": father.getFullName()) + // father +
                ", Мать: " + ((getMother() == null )? "нет данных": mother.getFullName()) + // mother +
                ", Дети: " + children +
                ", id=" + id;
    }
}