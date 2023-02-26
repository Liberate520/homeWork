package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Gender gender;
    private Date birthDate;

    private Date deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;
    public Human(String name, Gender gender, Date birthDate) {
        this(name, gender, birthDate, null, null);
    }

    public Human(String name, Gender gender, Date birthDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() { return name; }

    public Date getBirthDate() { return birthDate; }

    public Human getFather(){ return father; }

    public Human getMother(){ return mother; }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat ft =
                new SimpleDateFormat ("yyyy");
        sb.append("name: ");
        sb.append(name);
        sb.append(", ");
        sb.append("born: ");
        sb.append(ft.format(birthDate));
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getMotherInfo(){
        String res = "mother: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    private String getFatherInfo(){
        String res = "father: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "unknown";
        }
        return res;
    }

    private String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for(int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("no");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}
