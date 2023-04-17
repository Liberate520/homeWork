package familyTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Human {

    private String lastName;
    private String firstName;
    private String middleName;
    private Gender gender;
    private String dateOfBirth;
    private String dateOfDeath;
    private String mother;
    private String father;
    private String spouse;
    private String childs;


    // #region конструкторы

    /**
     * Конструктор, принимающий все аргументы
     * @param lastName фамилия
     * @param firstName имя
     * @param middleName отчество
     * @param gender пол
     * @param dateOfBirth дата рождения
     * @param dateOfDeath дата смерти
     * @param mother имя матери
     * @param father имя отца
     */
    public Human(String lastName, String firstName, String middleName,
                 Gender gender, String dateOfBirth, String dateOfDeath,
                 String mother, String father,
                 String spouse, String childs) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.spouse = spouse;
        this.childs = childs;
    }

    /**
     * Конструктор для живущих людей
     * @param lastName фамилия
     * @param firstName имя
     * @param middleName отчество
     * @param gender пол
     * @param dateOfBirth дата рождения
     * @param mother имя матери
     * @param father имя отца
     */
    public Human(String lastName, String firstName, String middleName,
                 Gender gender, String dateOfBirth,
                 String mother, String father,
                 String spouse, String childs) {
        this(lastName, firstName, middleName, gender, dateOfBirth, "---",
                mother, father, spouse, childs);
    }

    // #endregion

    // #region getter and setter

    /**
     * Получение полного имени
     * @return строка вида Фамилия Имя Отчество
     */
    public String getFullName() {
        return String.format("%s %s %s", this.lastName, this.firstName, this.middleName);
    }

    /**
     * Получение пола
     * @return пол человека
     */
    public String getGender() {
        if (this.gender == Gender.male) return "муж.";
        if (this.gender == Gender.female) return "жен.";
        else return null;
    }

    /**
     * Получение даты рождения
     * @return тип LocalDate вида дд.мм.гггг
     */
    public LocalDate getDateOfBirth() {
        return LocalDate.parse(this.dateOfBirth, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }

    /**
     * Установка даты рождения
     * @param dateOfBirth строка вида дд.мм.гггг
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Получение даты смерти
     * @return строка вида дд.мм.гггг
     */
    public LocalDate getDateOfDeath() {
        if (!this.dateOfDeath.equals("---"))
            return LocalDate.parse(this.dateOfDeath, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        else return null;
    }

    /**
     * Установка даты смерти
     * @param dateOfDeath строка вида дд.мм.гггг
     */
    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    /**
     * Получение имени матери
     * @return строка вида Фамилия Имя Отчество
     */
    public String getMother() {
        return this.mother;
    }

    /**
     * Получение имени отца
     * @return строка вида Фамилия Имя Отчество
     */
    public String getFather() {
        return this.father;
    }

    /**
     * Получение имени супруга
     * @return строка вида Фамилия Имя Отчество
     */
    public String getSpouse() {
        return spouse;
    }

    /**
     * Добавление нового супруга
     * @param str строка вида Фамилия Имя Отчество
     * @return строка вида  Фамилия Имя Отчество
     */
    public String setSpouse(String str) {
        return this.spouse + ", " + str;
    }

    /**
     * Дети
     * @return строка вида  Фамилия Имя Отчество через запятую
     */
    public String getChilds() {
        return childs;
    }

    /**
     * Добавление нового ребёнка
     * @param str строка вида  Фамилия Имя Отчество
     * @return все дети
     */
    public String setChild(String str) {
        return this.childs + ", " + str;
    }

    // #endregion

    // #region Переопределение equals, hashCode, toString

    @Override
    public int hashCode() {
        final int mod = 31;
        int res = 1;
        res = mod * res + (this.getFullName() == null ? 0 : this.getFullName().hashCode());
        res = mod * res + (this.getDateOfBirth() == null ? 0 : this.getDateOfBirth().hashCode());
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
        String dateOfDeath = "---";
        if (this.getDateOfDeath() != null)
            dateOfDeath = this.getDateOfDeath().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        return "ФИО: " + this.getFullName() + ",\nпол: " + this.getGender() + ",\nдаты рождения/смерти: "
                + this.getDateOfBirth().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
                + ", " + dateOfDeath + ",\nмать/отец: " + this.getMother() + ", " + this.getFather()
                + ",\nсупруг(а): " + this.getSpouse() + ",\nдети: " + this.getChilds();
    }

    // #endregion
}
