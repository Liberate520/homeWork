import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstname;
    private Human mother;
    private Human father;
    private Sex sex;
    private List<Human> children;


    public Human(String firstname, Sex sex) {
        this(firstname, sex, null, null);
    }

    public Human(String firstname, Sex sex, Human father, Human mother) {
        this.firstname = firstname;
        this.sex = sex;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getFamilyInfo() {
        StringBuilder res;
        res = new StringBuilder();
        res.append("Имя: ").append(firstname).append(". ")
                .append(getMotherInfo()).append(". ")
                .append(getFatherInfo()).append(". ")
                .append(getChildrenInfo()).append(". ");
        return res.toString();
    }

    private String getMotherInfo() {
        String info = "Мать: ";
        if (mother != null) {
            info += mother.getFirstname();
        } else {
            info += "неизвестна";
        }
        return info;
    }

    private String getFatherInfo() {
        String info = "Отец: ";
        if (father != null) {
            info += father.getFirstname();
        } else {
            info += "неизвестен";
        }
        return info;
    }

    private String getChildrenInfo() {
        StringBuilder res;
        res = new StringBuilder();
        res.append("Дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getFirstname());
            for (Human child : children) {
                res.append(", ").append(child.getFirstname());
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
        return human.getFirstname().equals(getFirstname());
    }
}