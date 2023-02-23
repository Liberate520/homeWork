import java.io.Serializable;
import java.util.ArrayList;

public class Human implements Serializable{
    private String name;
    private Sex sex;
    private String birthDate;
    private Human father;
    private Human mother;
    private Human partner;
    private ArrayList<Human> children;

    public Human(String name, Sex sex, String birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public Human() {
        this("Не установлено", null, null);
    }

    public Human(String name) {
        this(name, null, null);
    }

    /**
     * * Метод добавления ребенка к человеку.
     * @param somebody Ребенок, которого нужно добавить.
     * @param children Список детей человека
     */
    public ArrayList<Human> addChild (Human somebody) {
        this.children.add(somebody);
        return children;
    }

    /**
     * Метод вывода всех детей указанного человека
     */
    public void getChildren() {
        if (children.size() == 0) {
            System.out.printf("%s не имеет детей", name);
        } else {
            System.out.printf("%s имеет детей:\n", name);
            for (Human child : children) {
                System.out.println(child.getName() + " " + child.getBirthDate() + " г.р.");
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("%s, пол %s, %s г.р.", name, sex, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public Human getPartner() {
        return partner;
    }

    public void setPartner(Human partner) {
        this.partner = partner;
    }
}
