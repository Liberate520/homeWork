import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private long id;
    private String name;
    private Gender gender;
    private String birthDate;
    private String deathDate;
    private Human father, mother;
    private List<Human> children;
    private Human spouse;


    public Human(String name, Gender gender, String birthDate, String deathDate,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();

    }

    public Human(String name, Gender gender, String birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, String birthDate,
                 Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    /**
     * Метод добавляющий родителю ссылку на ребенка
     *
     * @param child - ссылка на ребенка
     *                           TODO
     *                           пока не понимаю для чего нужен return
     * @return
     */
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Метод возвращающий возраст в годах если человек жив,
     * и количтво прожитых лет если умер.
     * @return
     */
    public int getAge() {
        if (deathDate == null)
            return getPeriod(LocalDate.parse(birthDate), LocalDate.now());
        else return getPeriod(LocalDate.parse(birthDate), LocalDate.parse(deathDate));
    }

    /**
     * Метод возвращающий период между днем роздения и датой смерти
     *  в годах
     * @return
     */
    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    /**
     * Переписываем метод toString для корректного
     * отображения информации в консоль
     * @return
     */
    @Override
    public String toString() {
        return getInfo();
    }

    /**
     * Метод комплектующий и возвращающий строку с информацией
     * @return
     */
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст :");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    /**
     * Метод возвращающий строку с именем супруга(и) если такие имеются.
     * Или строку "нет" если таких нет.
     * @return
     */
    public String getSpouseInfo() {
        String result = "супруг(а): ";
        if (spouse == null)
            result += "нет";
        else result += spouse.getName();
        return result;
    }

    /**
     * Метод возвращающий строку с именем матери если о ней известно.
     * Или строку "неизвестна" если о матери нет информации.
     * @return
     */
    public String getMotherInfo() {
        String result = "мать: ";
        Human mother = getMother();
        if (mother == null)
            result += "неизвестна";
        else result += mother.getName();
        return result;
    }

    /**
     * Метод возвращающий строку с именем отца если о нем известно.
     * Или строку "неизвестен" если об отце нет информации.
     * @return
     */
    public String getFatherInfo() {
        String result = "отец: ";
        Human father = getFather();
        if (father == null)
            result += "неизвестен";
        else result += father.getName();
        return result;
    }

    /**
     * Метод перебирает циклом детей, если они есть.
     * Добавляет их имена в строку.
     * @return строку с именами детей
     *      * Или строку "неизвестна" если их нет.
     */
    public String getChildrenInfo() {
        String result = "дети: ";
        List<Human> childrens = getChildren();
        if (childrens == null)
            result += "нет детей";
        else {
            for (Human children : childrens)
                result += children.getName() + ", ";
        }
        return result;
    }

    /**
     * Сравнивает является ли текущий объект входящим.
     * @param obj - входящий объект
     * @return true - является
     *          false - неявляется
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Human))
            return false;
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
