package oop.familyTree.mvp.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human implements Serializable, HumanNode {

    private final long SerialVersionUID = 1L;
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private List<String> spouse;
    private List<String> children;

    // #Конструкторы

    /**
     * Конструктор, принимающий все аргументы
     * @param fullName строка вида Фамилия Имя Отчество
     * @param gender пол
     * @param dateOfBirth дата рождения строка вида дд.мм.гггг
     * @param dateOfDeath дата смерти строка вида дд.мм.гггг
     * @param mother имя матери строка вида Фамилия Имя Отчество
     * @param father имя отца строка вида Фамилия Имя Отчество
     * @param spouse имена супругов строка вида Фамилия Имя Отчество, через запятую
     * @param children имена детей строка вида Фамилия Имя Отчество, через запятую
     */
    public Human(String fullName, String gender,
                 LocalDate dateOfBirth, LocalDate dateOfDeath,
                 String mother, String father,
                 String spouse, String children) {
        this.fullName = fullName;
        this.gender = this.setGender(gender);

        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;

        this.mother = new Human(mother);
        this.father = new Human(father);

        if (!spouse.equals("")) this.spouse = new ArrayList<>(Arrays.asList(spouse.split(", ")));
        else this.spouse = new ArrayList<>();

        if (!children.equals("")) this.children = new ArrayList<>(Arrays.asList(children.split(", ")));
        else this.children = new ArrayList<>();
    }

    /**
     * Конструктор принимающий только ФИО
     * @param fullName имя строка вида Фамилия Имя Отчество
     */
    public Human(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Конструктор
     */
    public Human(){
    }

    // #Конец



    // #Getter and setter

    /**
     * Получение полного имени
     * @return String
     */
    public String getFullName() {
        if (this.fullName.equals("")) return "Человек не найден.";
        return this.fullName;
    }

    /**
     * Получение пола
     * @return String
     */
    public String getGender() {
        if (this.gender == Gender.male) return "мужской";
        if (this.gender == Gender.female) return "женский";
        else return "не определён";
    }

    /**
     * Установка пола
     * @param gender строка "мужской" или "женский"
     * @return Gender
     */
    public Gender setGender(String gender){
        if (gender.equals("мужской")) return Gender.male;
        if (gender.equals("женский")) return Gender.female;
        else return Gender.notDefined;
    }

    /**
     * Получение даты рождения
     * @return LocalDate
     */
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Получение даты смерти
     * @return LocalDate
     */
    public LocalDate getDateOfDeath() {
        return this.dateOfDeath;
    }

    /**
     * Установка даты
     * @param date строка вида дд.мм.гггг
     * @return LocalDate
     */
    public LocalDate setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(date, formatter);
    }

    /**
     * Расчёт возраста
     * @return int
     */
    public int getAge() {
        dateOfBirth = this.getDateOfBirth();
        dateOfDeath = this.getDateOfDeath();
        if (dateOfBirth == null) dateOfBirth = LocalDate.now();
        return Period.between(dateOfBirth,
                Objects.requireNonNullElseGet(dateOfDeath, LocalDate::now)).getYears();
    }

    /**
     * Получение имени матери
     * @return String
     */
    public String getNameMother() {
        StringBuilder name = new StringBuilder();
        Optional<String> opt = Optional.ofNullable(this.mother.getFullName());
        opt.ifPresentOrElse(
                v -> name.append(this.mother.getFullName()),
                () -> name.append("Человек не найден"));
        return name.toString();
    }

    /**
     * Получение имени отца
     * @return String
     */
    public String getNameFather() {
        StringBuilder name = new StringBuilder();
        Optional<String> opt = Optional.ofNullable(this.father.getFullName());
        opt.ifPresentOrElse(
                v -> name.append(this.father.getFullName()),
                () -> name.append("Человек не найден"));
        return name.toString();
    }

    /**
     * Установка имени
     * @param fullName полное имя
     * @return Human
     */
    public Human setName(String fullName){
        return new Human(fullName);
    }

    /**
     * Получение имён супругов
     * @return String
     */
    public String getSpouse() {
        StringBuilder spouse = new StringBuilder();
        if (this.spouse != null) {
            if (this.spouse.size() != 0)
                spouse.append(String.join(", ", this.spouse));
        }
        else spouse.append("Человек не найден.");
        return spouse.toString();
    }

    /**
     * Получение имён детей
     * @return String
     */
    public String getChildren() {
        StringBuilder children = new StringBuilder();
        if (this.children != null) {
            if (this.children.size() != 0)
                children.append(String.join(", ", this.children));
        }
        else children.append("Человек не найден.");
        return children.toString();
    }


    /**
     * Добавление нового супруга
     * @param str строка вида Фамилия Имя Отчество
     */
    public void setSpouse(String str) {
        this.spouse.add(str);
    }

    /**
     * Добавление нового ребёнка
     * @param str строка вида  Фамилия Имя Отчество
     */
    public void setChild(String str) {
        this.children.add(str);
    }

    // #Конец

    // #Переопределение equals, hashCode, toString

    @Override
    public int hashCode() {
        final int mod = 31;
        int res = 1;
        res = mod * res + (this.getFullName() == null ? 0 : this.getFullName().hashCode());
        res = mod * res * (this.getDateOfBirth() == null ? 0 : this.getDateOfBirth().hashCode());
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return  true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Human human = (Human) obj;
        return (Objects.equals(((Human) obj).getFullName(), human.getFullName())
                || (((Human) obj).getFullName() != null
                && ((Human) obj).getFullName().equals(human.getFullName())))
                && (((Human) obj).getDateOfBirth() == human.getDateOfBirth()
                || ((Human) obj).getDateOfBirth() != null
                && ((Human) obj).getDateOfBirth().equals(human.getDateOfBirth()));
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("__________").append("\n");
        sb.append("ФИО: ").append(this.getFullName()).append("\n");
        sb.append("пол: ").append(this.getGender()).append("\n");
        if (this.getDateOfBirth() != null) {
            sb.append("дата рождения: ")
                    .append(this.getDateOfBirth().format(formatter))
                    .append("\n");
        }
        if (this.getDateOfDeath() != null) {
            sb.append("дата смерти: ")
                    .append(this.getDateOfDeath().format(formatter))
                    .append("\n");
        }
        sb.append("возраст: ").append(this.getAge()).append("\n");
        sb.append("мать: ").append(this.getNameMother()).append("\n");
        sb.append("отец: ").append(this.getNameFather()).append("\n");
        sb.append("супруг(а)(и): ").append(this.getSpouse()).append("\n");
        sb.append("дети: ").append(this.getChildren()).append("\n");
        return sb.toString();
    }

    // #Конец
}