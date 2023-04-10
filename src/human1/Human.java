package human1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(int id, String name, Human mother, Human father) {
        this.id = id;
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(String name) {this(name, null, null); }

    public Human(String name2, Object object, Object object2) {
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Human getMother() {
        return mother;
    }
    
    public Human getFather() {
        return father;
    }


    public List<Human> getChildren() {
        return children;
    }

    public String printHuman(){
        StringBuilder sb = new StringBuilder();
        sb.append("№ ");
        sb.append(id);
        sb.append(" имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getInfo() {
        return String.format("Семья: ", printHuman());
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if(mother != null) {
            res += mother.getName();
        }
        else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (father != null) {
            res += father.getName();
        }
        else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
            } else {
                res.append("детей нет");
            }
            return res.toString();
        }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}