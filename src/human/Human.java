package human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private static int count = 1;
    private int id;
    private String name;
    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    private Human father;
    private Human mother;

    private List<Human> children;

    public Human(String name, Gender gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender) {
        this(name, gender,null, null);
    }

    public boolean addChild(Human child) {
        if (!children.contains((child))) {
            children.add(child);
            return true;
        }
        return false;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Human.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public void setDateDeath(LocalDate dateDeath) {
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

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(" , ");
        sb.append(getFatherInfo());
        sb.append(" , ");
        sb.append(getMotherInfo());
        sb.append(" , ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getFatherInfo() {
        String res = "Отец: ";
        if (father != null) {
            res += father.getname();
        } else {
            res += "неизветстен";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "Мать: ";
        if (father != null) {
            res += mother.getname();
        } else {
            res += "неизветстна";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getname());
            for (int i = 1; i < children.size(); i++) {
                res.append(", " + children.get(i).getname());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getname().equals(getname());
    }
}

