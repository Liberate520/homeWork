package human;
import org.jetbrains.annotations.NotNull;
import tree.FamilyTree;
import tree.FamilyTreeItem;
import java.io.Serializable;
import java.time.*;
import java.util.*;

//public class Human implements Serializable, FamilyTreeItem< Human >, Comparable<Human> {
public class Human implements FamilyTreeItem< Human > {
    private int id;
    private String lastname;
    private String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private Gender gender;
    private Map< String, Human > parents;
    private List< Human > children;
    Human spouse;

    public Human(int id, String lastname, String name, LocalDate birthday, Gender gender) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap< String, Human >();
        this.children = new ArrayList<>();
        setDayOfBirth(birthday);
    }

    public Human(int id, String lastname, String name, Gender gender) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap< String, Human >();
        this.children = new ArrayList< Human >();
    }

    public Human(int id, String lastname, String name, LocalDate birthday, LocalDate dayOfDeath, Gender gender, Human parent1, Human parent2) {
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap< String, Human >();
        this.children = new ArrayList< Human >();
        setDayOfBirth(birthday);
        setDayOfDeath(dayOfDeath);
        if (parent1 != null) {
            setParent(parent1);
        }
        if (parent2 != null) {
            setParent(parent2);
        }
    }

    //геттеры:

    /**
     * Получение значения ID
     *
     * @return Строка вида 'ID.'
     */
    public String getId() {
        return this.id + ". ";
    }

    /**
     * Получение Имени
     *
     * @return Строка Имя
     */
    public String getName() {
        return name;
    }

    /**
     * Получение фамилии
     *
     * @return Строка Фамилия
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Получение "Имя Фамилия" из отдельных методов
     *
     * @return Строка "Имя Фамилия"
     */
    public String getFullName() {
        return this.getLastname() + " " + this.getName();
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    /**
     * вычисление возраста для живущих, возврат даты смерти для умерших
     *
     * @return число в строку - возраст или строка даты смерти
     */
    public int getAge() {
            return Period.between(this.dayOfBirth, LocalDate.now()).getYears();
    }

    public Gender getGender() {
        return gender;
    }

    /**
     * Получение списка родителей в формате Мать=ААА, Отец=ВВВ
     *
     * @return Стринг билдер в строку
     */
    public String getParents() {
        StringBuilder sb = new StringBuilder("Родители: ");
        if (this.parents.isEmpty()) {
            sb.append("Данных нет");
        } else {
            sb.append(this.parents);
        }
        return sb.toString().replace("=", ": ");
    }

    /**
     * Получение списка детей в формате перечисления
     *
     * @return Строка Дети: ААА, БББ, ВВВ
     */
    public String getChildren() {
        if (this.children.isEmpty()) {
            return "Детей нет";
        }
        return "Дети: " + this.children;
    }

    /**
     * Получение Имени и Фамилии супруга
     *
     * @return Строка "Супруг: Фамилия Имя"
     */
    public String getSpouse() {
        if (this.spouse == null) {
            return "Не женат/замужем";
        }
        return "Супруг: " + this.spouse;
    }

    // Сетеры:

    /**
     * Установка ID
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Установка супружества: супруг1.spouse(супруг2)
     *
     * @param spouse
     */
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    /**
     * Установка дня рождения
     *
     * @param dayOfBirth
     */
    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * Установка дня смерти
     *
     * @param dayOfDeath
     */
    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    /**
     * присвоение родителя человеку
     *
     * @param human
     */

    public void setParent(Human human) {
        if (human.getGender() == Gender.Male) {
//            this.parents.put("Отец " , " " + human.getFullName());
//            this.parents.put("Отец",  human);
            this.parents.put("Отец",  human);
        }
//        else this.parents.put("Мать " , " " + human.getFullName());
        else this.parents.put("Мать ", human);
    }

    /**
     * присвоение ребенка человеку
     *
     * @param human
     */
    public void setChild(Human human) {
        if (!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    /**
     * Переопределенный toString
     *
     * @return
     */
    @Override
    public String toString() {
        return (lastname + " " + name + " " + dayOfBirth + " " + gender);
    }

//    @Override
//    public int compareTo(Human o) {
//        if(this.getAge()>o.getAge())
//            return 1;
//        else if (getAge()<o.getAge())
//            return -1;
//        else return 0;
//    }
}