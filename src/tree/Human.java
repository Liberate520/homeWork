package tree;

import java.util.ArrayList;
import java.util.List;

public class Human {
    // private List<Human> human;
    private Gender gender;
    private String name;
    private Human mother;
    private Human father;
    private List<Human> children;
    
    public Human(Gender gender, String name){
        this.gender = gender;
        this.name = name;
    }

    public Human(Gender gender, String name, Human mother, Human father){
        this(gender, name);
        this.mother = mother;
        this.father = father;
    }

    public Human(Gender gender, String name, Human mother, Human father, List<Human> children){
        this(gender, name, mother, father);
        this.children = children;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setChildren(Human human) {
        this.children.add(human);
    }

    public String getParents() {
        return mother.getName() + " " + father.getName();
    }

    public String getGrandParents() {
        return mother.getParents() + " " + father.getParents();
    }

    public List<String> getChildren() {
        return ((Human) children).childrenToString();
    }

    public List<String> childrenToString() {
        List<String> res = new ArrayList<>();
        for (Human human : children) {
            res.add(human.getName());
        }
        return res;
    }

    public List<String> getBrothersAndSisters() {
        return mother.getChildren();
    }

    @Override
    public String toString() {
        String m = "";
        String f = "";
        List<String> c = new ArrayList<>();
        if (mother != null) m = mother.getName();
        if (father != null) f = father.getName();
        if (children != null) c = ((Human) children).childrenToString();
        return "Имя: " + name + "\nпол: " + gender + "\nМать: " + m + "\nОтец: " + f + "\nДети: " + c + "\n";
    }
}
