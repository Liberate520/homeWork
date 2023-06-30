package faminly_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name, surname, patronymic;
    private Gender gender;
    private LocalDate birth, death;
    private Human mother, father;
    private List<Human> children;
    private int age;

    /**
     * Определение возраста по дате смерти, если она есть или по текущей дате
     * @param birth дата рождения
     * @param death дата смерти
     * @return
     */
    private int getAge(LocalDate birth, LocalDate death){
        int age;
        int birthYear = birth.getYear();
        int birthMonth = birth.getMonthValue();
        int birthDay = birth.getDayOfMonth();
        if (death == null){
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
        }
        else {
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
        return age;
    }

    // Не уверена, насколько корректно добавлять в переменные-параметры конструктора переменные, не объявленные в классе,
    // нужно ли мне их объявлять,если по факту они используются только, чтобы заполнить переменную внутри конструктора,
    // которая в свою очередь в классе объявлена? В данном случае речь о LocalDate birth, death.
    // Я мало знакома с классом LocalDate и не нашла другого способа заполнить такую переменную.
    public Human(String name, /*String surname, String patronymic,*/ Gender gender, int birthYear, int birthMonth, int birthDay, int deathYear, int deathMonth, int deathDay) {
        this.name = name;
        //this.surname = surname;
        //this.patronymic = patronymic;
        this.gender = gender;
        this.birth = LocalDate.of(birthYear, birthMonth, birthDay);
        this.death = LocalDate.of(deathYear, deathMonth, deathDay);
        this.age = getAge(birth, death);
    }
    public Human(String name, /*String surname, String patronymic,*/ Gender gender, int birthYear, int birthMonth, int birthDay) {
        this.name = name;
        //this.surname = surname;
        //this.patronymic = patronymic;
        this.gender = gender;
        this.birth = LocalDate.of(birthYear, birthMonth, birthDay);
        this.death = null;
        this.age = getAge(birth, death);
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
    public String getChildrenToString() {
        return children.toString().replaceAll("]", "").replaceAll("\\[", "").replaceAll("\n, ", "\n\n");
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

    @Override
    public String toString(){
        return "Имя: " + name + ", Фамилия: " + surname + ", Отчество: " + patronymic + ".\n"
                + "Дата рождения: " + birth + ".\n"
                + "Возраст: " + age + ".\n";

    }
}
