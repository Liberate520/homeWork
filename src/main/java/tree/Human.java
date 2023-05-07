package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable {
    private Gender gender;
    private Human mother;
    private Human father;
    private String name;
    private List<Human> children;

    public Human(String name, Gender gender) {
        this(name, gender, null, null );

    }
    public Human(String name,Gender gender, Human mother, Human father ) {
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.name = name;
        children = new ArrayList<>();
    }
    public void addChild(Human child){
        children.add(child);
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



    public String getInfo(){
        StringBuilder strb = new StringBuilder();
        strb.append("Имя:");
        strb.append(name);
        strb.append(",");
        strb.append(getFatherInfo());
        strb.append(", ");
        strb.append(getMotherInfo());
        strb.append(", ");
        strb.append(getChildrenInfo());
        return strb.toString();
    }
    public String getMotherInfo(){
        String m;
        if (mother != null){
            m = "Мать " + mother.getName();
        } else {
            m = " Нет";
        }
        return m;
    }
    public String getFatherInfo(){
        String f;
        if (father != null){
            f = "Отец " + father.getName();
        } else {
            f = " Нет";
        }
        return f;
    }
    public String getChildrenInfo(){
        StringBuilder c = new StringBuilder();
        if (children.size() != 0){
            c.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                c.append(", ");
                c.append(children.get(i).getName());
            }
        } else {
            c.append(" Нет");
        }
        return c.toString();
    }

}
