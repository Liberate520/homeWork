import java.util.*;
import java.util.Date;
import java.io.Serializable;

// класс ("чертеж" Хумана) - описание того, какими свойствами и поведением (переменные и функции=методы) будет обладать объект
public class Human implements Serializable {
    // объявление полей (переменные)
    private String name;
    private String gender;
    private Date dateBorn;
    private Date dateDeath;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String gender) {
        this(name, gender, null, null);
    }
    // метод конструктор
    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    // метод выдачи имени
    public String getName() {
        return name;
    }

    public void setName(String name) {
        // обращение к собственному атрибуту через this
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public Date getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(Date dateDeath) {
        this.dateDeath = dateDeath;
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

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getName();
        }
        else {
            res += "нет";
        }
        return res;
    }

    private String getMotherInfo() {
        String res = "Мать: ";
        if (mother != null) {
            res += mother.getName();
        }
        else {
            res += "нет";
        }
        return res;
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети (");
        res.append(children.size());
        res.append("): ");
        if (children.size() != 0) {
            for (int i = 0; i < children.size(); i++) {
                res.append(children.get(i).getName());
                res.append(", ");
            }
        }
        else {
            res.append("нет");
        }
        res.append("\n");
        return res.toString();
    }


}
