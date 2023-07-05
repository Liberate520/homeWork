package faminly_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Human {
    private int id;
    private String name, surname, patronymic;
    private Gender gender;
    private LocalDate birth, death;
    private Human mother, father;
    private List<Human> children;
    private String age;

    public Human(String name, String surname, String patronymic, Gender gender, LocalDate birth, LocalDate death) {
        this.id = -1;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.age = getAge(birth, death);
    }
    public Human(String name, String surname, String patronymic, Gender gender, LocalDate birth) {
        this(name, surname, patronymic, gender, birth, null);
    }
    public Human(String name, Gender gender, LocalDate birth) {
        this(name, null, null, gender, birth, null);
    }
    public Human(String name, Gender gender, LocalDate birth, LocalDate death) {
        this(name, null, null, gender, birth, death);
    }

    /**
     * Определение возраста по дате смерти, если она есть или по текущей дате
     *
     * @param birth дата рождения
     * @param death дата смерти
     * @return
     */
    private String getAge(LocalDate birth, LocalDate death) {
        if (birth == null) return null;
        int age;
        int birthYear = birth.getYear();
        int birthMonth = birth.getMonthValue();
        int birthDay = birth.getDayOfMonth();
        if (death == null) {
            LocalDate date = LocalDate.now();
            int year = date.getYear();
            int month = date.getMonthValue();
            int day = date.getDayOfMonth();
            if (birthMonth == month) {
                if (day >= birthDay) age = year - birthYear;
                else age = year - birthYear - 1;
            }
            if (month > birthMonth) age = year - birthYear;
            else age = year - birthYear - 1;
        } else {
            int deathYear = death.getYear();
            int deathMonth = death.getMonthValue();
            int deathDay = death.getDayOfMonth();
            if (birthMonth == deathMonth) {
                if (deathDay >= birthDay) age = deathYear - birthYear;
                else age = deathYear - birthYear - 1;
            }
            if (deathMonth > birthMonth) age = deathYear - birthYear;
            else age = deathYear - birthYear - 1;
        }
        return Integer.toString(age);
    }

    /**
     * Определение взаимосвязи ребенок-родитель
     *
     * @param human родитель
     */
    public void childFor(Human human) {
        if (human.gender == Gender.Male) {
            this.setFather(human);
        } else {
            this.setMother(human);
        }
        List<Human> children = human.getChildren();
        if (children == null) {
            children = new ArrayList<>();
            children.add(this);
        } else children.add(this);
        human.setChildren(children);
    }

    //TODO метод брака
    //TODO метод развода
    //TODO метод смерти

    //Методы вывода информации с исп. toString
    @Override
    public String toString() {
        return getInfo();
    }
    private String motherGetInfo() {
        StringBuilder sb = new StringBuilder();
        if (this.getMother() != null) sb.append(this.getMother().getName());
        else sb.append("неизвестна");
        return sb.toString();
    }
    private String fatherGetInfo() {
        StringBuilder sb = new StringBuilder();
        if (this.getFather() != null) sb.append(this.getFather().getName());
        else sb.append("неизвестен");
        return sb.toString();
    }
    private String childrenGetInfo(){
        StringBuilder sb = new StringBuilder();
        List<Human> children = this.getChildren();
        if (children == null) sb.append("отсутствуют или не указаны");
        else {
            for(Human el : children){
                sb.append(el.getName());
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }
    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        if (this.name != null) {
            sb.append(", имя: ");
            sb.append(name);
        }
        if (this.surname != null) {
            sb.append(", фамилия: ");
            sb.append(surname);
        }
        if (this.patronymic != null) {
            sb.append(", отчество: ");
            sb.append(patronymic);
        }
        if (this.age != null) {
            sb.append(", возраст: ");
            sb.append(age);
        }
        sb.append(", мать: ");
        sb.append(motherGetInfo());
        sb.append(", отец: ");
        sb.append(fatherGetInfo());
        sb.append(", дети: ");
        sb.append(childrenGetInfo());
        return sb.toString();
    }

    //Далее сеттеры и геттеры
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public LocalDate getBirth() {
        return birth;
    }
    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }
    public LocalDate getDeath() {
        return death;
    }
    public void setDeath(LocalDate death) {
        this.death = death;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    public List<Human> getChildren() {
        return children;
    }
    public Human getFather() {
        return father;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public void setId(int id) {
        this.id = id;
    }
}
