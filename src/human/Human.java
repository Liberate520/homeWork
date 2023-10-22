package human;
import tree.FamilyTree;
import java.time.*;
import java.util.*;

public class Human {
    private int id;
    private final String lastname;
    private final String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private final Gender gender;
    private final Map< String, String > parents;
    private final List< Human > children;
    Human spouse;

    public Human(FamilyTree family, String lastname, String name, LocalDate birthday, Gender gender) {
        this.lastname = lastname;
        this.name = name;
        this.gender = gender;
        this.parents = new HashMap<>();
        this.children = new ArrayList<>();
        setDayOfBirth(birthday);
        family.addHuman(this);
    }


    //геттеры:

    /**
     * Получение значения ID
     * @return Строка вида 'ID.'
     */
    public String getId() {
        return this.id + ". ";
    }

    /**
     * Получение Имени
     * @return Строка Имя
     */
    public String getName() {
        return name;
    }

    /**
     * Получение фамилии
     * @return Строка Фамилия
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Получение "Имя Фамилия" из отдельных методов
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
     * @return число в строку - возраст или строка даты смерти
     */
    public String getAge() {
        if (this.dayOfDeath == null) {
            return Integer.toString(Period.between(this.dayOfBirth, LocalDate.now()).getYears());
        } else {
            return String.valueOf(this.dayOfDeath);
        }
    }

    public Gender getGender() {
        return gender;
    }

    /**
     * Получение списка родителей в формате Мать=ААА, Отец=ВВВ
     * @return Стринг билдер в строку
     */
    public String getParents() {
        StringBuilder sb = new StringBuilder("Родители: ");
        if (this.parents.isEmpty()){
            sb.append("Данных нет");
        }
        else{
            sb.append(this.parents);
        }
        return sb.toString();
    }

    /**
     * Получение списка детей в формате перечисления
     * @return Строка Дети: ААА, БББ, ВВВ
     */
    public String getChildren() {
        if(this.children.isEmpty()){
            return "Детей нет";
        }
        return "Дети: " + this.children;
    }

    /**
     * Получение Имени и Фамилии супруга
     * @return Строка "Супруг: Фамилия Имя"
     */
    public String getSpouse() {
        if(this.spouse == null){
            return "Не женат/замужем";
        }
        return "Супруг: " + this.spouse;
    }

    // Сетеры:

    /**
     * Установка ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Установка супружества: супруг1.spouse(супруг2)
     * @param spouse
     */
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
        spouse.spouse = this;
    }

    /**
     * Установка дня рождения
     * @param dayOfBirth
     */
    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    /**
     * Установка дня смерти
     * @param dayOfDeath
     */
    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    /**
     * присвоение родителя человеку
     * @param human
     */
    private void setParent(Human human) {
        if (human.getGender() == Gender.Male) {
            this.parents.put("Отец " , " " + human.getFullName());
        }
        else this.parents.put("Мать " , " " + human.getFullName());
    }

    /**
     * присвоение ребенка человеку
     * @param human
     */
    public void setChild(Human human) {
        if(!children.contains(human)) {
            this.children.add(human);
            human.setParent(this);
        }
    }

    /**
     * Переопределенный toString
     * @return
     */
    @Override
    public String toString() {
        return (lastname + " " + name);
    }
}
