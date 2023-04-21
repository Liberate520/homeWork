package familyTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Human {

    private String lastName;
    private String firstName;
    private String middleName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human mother;
    private Human father;
    private List<String> spouse;
    private List<String> childs;

    // #region конструкторы

    /**
     * Конструктор, принимающий все аргументы
     * @param lastName фамилия
     * @param firstName имя
     * @param middleName отчество
     * @param gender пол
     * @param dateOfBirth дата рождения строка вида дд.мм.гггг
     * @param dateOfDeath дата смерти строка вида дд.мм.гггг
     * @param mother строка с именем матери вида ФИО
     * @param father строка с именем отца вида ФИО
     * @param spouse строка с именами супругов вида ФИО, через запятую
     * @param childs строка с именами детей вида ФИО, через запятую
     */
    public Human(String lastName, String firstName, String middleName,
                 Gender gender, String dateOfBirth, String dateOfDeath,
                 String mother, String father,
                 String spouse, String childs) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.gender = gender;

        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        if (!dateOfDeath.equals("")) {
            this.dateOfDeath = LocalDate.parse(dateOfDeath, DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        }
        else this.dateOfDeath = null;

        this.mother = FamilyTree.searchHuman(mother);
        this.father = FamilyTree.searchHuman(father);

        if (!spouse.equals("")) this.spouse = new ArrayList<>(Arrays.asList(spouse.split(", ")));
        else this.spouse = new ArrayList<>();

        if (!childs.equals("")) this.childs = new ArrayList<>(Arrays.asList(childs.split(", ")));
        else this.childs = new ArrayList<>();
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
        if (this.gender == Gender.male) return "мужской";
        if (this.gender == Gender.female) return "женский";
        return null;
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
     * Получение имени матери
     * @return строка вида Фамилия Имя Отчество
     */
    public String getMother() {
        if (this.mother != null) return this.mother.getFullName();
        else return null;
    }

    /**
     * Получение имени отца
     * @return строка вида Фамилия Имя Отчество
     */
    public String getFather() {
        if (this.father != null) return this.father.getFullName();
        else  return null;
    }

    /**
     * Получение имён супругов
     */
    public String getSpouse() {
        if (this.spouse.size() != 0) return String.join(", ", this.spouse);
        else return null;
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
    public String getChilds() {
        if (this.childs.size() != 0) return String.join(", ", this.childs);
        else return null;
    }

    /**
     * Добавление нового ребёнка
     * @param str строка вида  Фамилия Имя Отчество
     * @return да или нет
     */
    public boolean setChild(String str) {
        this.childs.add(str);
        return true;
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
        String dateOfDeath;
        if (this.getDateOfDeath() != null)
            dateOfDeath = this.getDateOfDeath().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        else dateOfDeath = null;
        return "\n__________\nФИО: " + this.getFullName()
                + "\nпол: " + this.getGender()
                + "\nдаты рождения/смерти: "
                + this.getDateOfBirth().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
                + " / " + dateOfDeath
                + "\nмать/отец: " + this.getMother() + ", " + this.getFather()
                + "\nсупруги: " + this.getSpouse()
                + "\nдети: " + this.getChilds() + "\n__________\n";
    }
    // #endregion
}