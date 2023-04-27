package familyTree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable {

    private int id;
    private final String FULL_NAME;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private List<String> spouse;
    private List<String> children;

    // #region конструкторы

    /**
     * Конструктор, принимающий все аргументы
     * @param id порядковый номер
     * @param fullName строка вида Фамилия Имя Отчество
     * @param gender пол
     * @param dateOfBirth дата рождения строка вида дд.мм.гггг
     * @param dateOfDeath дата смерти строка вида дд.мм.гггг
     * @param mother имя матери строка вида Фамилия Имя Отчество
     * @param father имя отца строка вида Фамилия Имя Отчество
     * @param spouse имена супругов строка вида Фамилия Имя Отчество, через запятую
     * @param children имена детей строка вида Фамилия Имя Отчество, через запятую
     */
    public Human(int id, String fullName, Gender gender,
                 String dateOfBirth, String dateOfDeath,
                 String mother, String father,
                 String spouse, String children) {
        this.id = id;
        this.FULL_NAME = fullName;
        this.gender = gender;

        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        if (!dateOfDeath.equals("")) {
            this.dateOfDeath = LocalDate.parse(dateOfDeath, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        }
        else this.dateOfDeath = null;

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
        this.FULL_NAME = fullName;
    }

    // #endregion

    // #region getter and setter

    /**
     * Получение полного имени
     * @return строка вида Фамилия Имя Отчество
     */
    public String getFullName() {
        if (this.FULL_NAME.equals("")) return "Человек не найден.";
        return this.FULL_NAME;
    }

    /**
     * Получение пола
     * @return пол человека
     */
    public String getGender() {
        if (this.gender == Gender.male) return "Пол мужской";
        if (this.gender == Gender.female) return "Пол женский";
        return "Пол не определён, т.к. человек не найден.";
    }

    /**
     * Получение даты рождения
     * @return дата в локальном формате
     */
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Установка даты рождения
     * @param dateOfBirth строка вида дд.мм.гггг
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }

    /**
     * Получение даты смерти
     * @return дата в локальном формате
     */
    public LocalDate getDateOfDeath() {
        return this.dateOfDeath;
    }

    /**
     * Установка даты смерти
     * @param dateOfDeath строка вида дд.мм.гггг
     */
    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = LocalDate.parse(dateOfDeath, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }

    /**
     * Расчёт возраста
     * @return число лет
     */
    public int getAge() {
        if (this.dateOfBirth == null) this.dateOfBirth = LocalDate.now();
        return Period.between(this.dateOfBirth,
                Objects.requireNonNullElseGet(this.dateOfDeath, LocalDate::now)).getYears();
    }

    /**
     * Получение имени матери
     * @return строка вида Фамилия Имя Отчество
     */
    public String getMother() {
        if (this.mother != null) return this.mother.getFullName();
        else return "Человек не найден.";
    }

    /**
     * Получение имени отца
     * @return строка вида Фамилия Имя Отчество
     */
    public String getFather() {
        if (this.father != null) return this.father.getFullName();
        else  return "Человек не найден.";
    }

    /**
     * Получение имён супругов
     */
    public String getSpouse() {
        String spouse = "";
        if (this.spouse != null) {
            if (this.spouse.size() != 0)
                spouse = String.join(", ", this.spouse);
        }
        else spouse = "Человек не найден.";
        return spouse;
    }

    /**
     * Добавление нового супруга
     * @param str строка вида Фамилия Имя Отчество
     * @return да или нет
     */
    public boolean setSpouse(String str) {
        this.spouse.add(str);
        return true;
    }

    /**
     * Дети
     * @return строка вида  Фамилия Имя Отчество через запятую
     */
    public String getChildren() {
        String children = "";
        if (this.children != null) {
            if (this.children.size() != 0) children = String.join(", ", this.children);
        }
        else children = "Человек не найден.";
        return children;
    }

    /**
     * Добавление нового ребёнка
     * @param str строка вида  Фамилия Имя Отчество
     * @return да или нет
     */
    public boolean setChild(String str) {
        this.children.add(str);
        return true;
    }

    // #endregion

    // #region Переопределение equals, hashCode, toString

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
        return (((Human) obj).getFullName() == human.getFullName()
                || (((Human) obj).getFullName() != null
                && ((Human) obj).getFullName().equals(human.getFullName())))
                && (((Human) obj).getDateOfBirth() == human.getDateOfBirth()
                || ((Human) obj).getDateOfBirth() != null
                && ((Human) obj).getDateOfBirth().equals(human.getDateOfBirth()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("__________").append("\n");
        sb.append("ФИО: ").append(this.getFullName()).append("\n");
        sb.append("пол: ").append(this.getGender()).append("\n");

        if (this.getDateOfBirth() != null) {
            sb.append("дата рождения: ")
                    .append(this.getDateOfBirth().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)))
                    .append("\n");
        }
        if (this.getDateOfDeath() != null) {
            sb.append("дата смерти: ")
                    .append(this.getDateOfDeath().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)))
                    .append("\n");
        }
        sb.append("мать: ").append(this.getMother()).append("\n");
        sb.append("отец: ").append(this.getFather()).append("\n");
        sb.append("супруг(а)(и): ").append(this.getSpouse()).append("\n");
        sb.append("дети: ").append(this.getChildren()).append("\n");
        return sb.toString();
    }
    // #endregion
}