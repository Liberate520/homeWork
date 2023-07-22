package faminly_tree.model.human;

import faminly_tree.model.human.get_info.HumanInfo;
import faminly_tree.model.tree.FamilyItem;
import java.time.LocalDate;
import java.util.List;

public class Human implements FamilyItem {
    private int id;
    private String name, surname, patronymic;
    private Gender gender;
    private LocalDate birth, death;
    private Human mother, father;
    private List<Human> children;
    private int age;
    //TODO проверить метод расчета возраста на тему нынешнего года и так же того факта что могут быть введены нули, если пользователь не знал конкретную дату

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
    //добавить учет того, что человек мог родится в этом же году
    private int getAge(LocalDate birth, LocalDate death) {
        if (birth == null) return 0;
        int age;
        int birthYear = birth.getYear();
        int birthMonth = birth.getMonthValue();
        int birthDay = birth.getDayOfMonth();
        if (birthYear == 0) return 0;
        else {
            if (death == null) {
                age = ageWithoutDeath(birthYear, birthMonth, birthDay);
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
        }
        return age;
    }
    private int ageWithoutDeath(int birthYear, int birthMonth, int birthDay) {
        LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        if (birthDay == 0 && birthMonth != 0) {
            if (month >= birthMonth) return year - birthYear;
            else return year - birthYear - 1;
        }
        else if (birthDay != 0 && birthMonth == 0) return year - birthYear;
        else if (birthDay != 0 && birthMonth != 0) {
            if (birthMonth == month) {
                if (day >= birthDay) return year - birthYear;
                else return year - birthYear - 1;
            }
            if (month > birthMonth) return year - birthYear;
            else return year - birthYear - 1;
        }
        else return 0;
    }

    //TODO метод смерти

    @Override
    public String toString() {
        HumanInfo info = new HumanInfo(this);
        return info.getInfo();
    }

    @Override
    public String getName() {
        return name;
    }
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
    @Override
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
    @Override
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    @Override
    public List<Human> getChildren() {
        return children;
    }
    @Override
    public Human getFather() {
        return father;
    }
    @Override
    public Gender getGender() {
        return gender;
    }
    @Override
    public void setMother(Human mother) {
        this.mother = mother;
    }
    @Override
    public Human getMother() {
        return mother;
    }
    @Override
    public void setId(int id) {
        this.id = id;
    }
}