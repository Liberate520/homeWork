package familyTree.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Human implements Serializable, FamilyTreeNode {

    private int id;
    private String fullName;
    private Gender gender;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
    private DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
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
    public Human(int id, String fullName, String gender,
                 String dateOfBirth, String dateOfDeath,
                 String mother, String father,
                 String spouse, String children) {
        this.id = id;
        this.fullName = fullName;
        this.gender = setGender(gender);


        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
        if (!dateOfDeath.equals("")) {
            this.dateOfDeath = LocalDate.parse(dateOfDeath, formatter);
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
        this.fullName = fullName;
    }

    // #endregion

    // #region getter and setter

    /**
     * Получение полного имени
     * @return строка вида Фамилия Имя Отчество
     */
    public String getFullName() {
        if (this.fullName.equals("")) return "Человек не найден.";
        return this.fullName;
    }

    /**
     * Получение пола
     * @return пол человека
     */
    public String getGender() {
        if (this.gender == Gender.male) return "мужской";
        if (this.gender == Gender.female) return "женский";
        else return "не определён";
    }

    /**
     * Установка пола
     * @param strGender строка "м" или "ж"
     * @return объект типа Gender
     */
    public Gender setGender(String strGender){
        if (strGender.equals("м")) return this.gender.male;
        if (strGender.equals("ж")) return this.gender.female;
        return this.gender.undefined;
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
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
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
        this.dateOfDeath = LocalDate.parse(dateOfDeath, formatter);
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
     * @return строка вида Фамилия Имя Отчество
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
     * Получение имён обоих родителей
     * @return строка с именами
     */
    public String getNameParents(){
        StringBuilder parents = new StringBuilder();
        StringBuilder nameM = new StringBuilder();
        Optional<String> optM = Optional.ofNullable(this.mother.getFullName());
        optM.ifPresentOrElse(
                v -> nameM.append(this.mother.getFullName()),
                () -> nameM.append("Человек не найден"));
        StringBuilder nameF = new StringBuilder();
        Optional<String> optF = Optional.ofNullable(this.father.getFullName());
        optF.ifPresentOrElse(
                v -> nameF.append(this.father.getFullName()),
                () -> nameF.append("Человек не найден"));
        return parents.append(nameM).append(", ").append(nameF).toString();
    }

    /**
     * Получение имён супругов
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
     * Добавление нового супруга
     * @param str строка вида Фамилия Имя Отчество
     * @return да или нет
     */
    public boolean setSpouse(String str) {
        this.spouse.add(str);
        return true;
    }

    /**
     * Получение имён детей
     * @return строка вида Фамилия Имя Отчество через запятую
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
                    .append(this.getDateOfBirth().format(formatter2))
                    .append("\n");
        }
        if (this.getDateOfDeath() != null) {
            sb.append("дата смерти: ")
                    .append(this.getDateOfDeath().format(formatter2))
                    .append("\n");
        }
        sb.append("мать: ").append(this.getNameMother()).append("\n");
        sb.append("отец: ").append(this.getNameFather()).append("\n");
        sb.append("супруг(а)(и): ").append(this.getSpouse()).append("\n");
        sb.append("дети: ").append(this.getChildren()).append("\n");
        return sb.toString();
    }
    // #endregion
}