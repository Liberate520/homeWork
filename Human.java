package three;

import java.util.ArrayList;
import java.util.List;

public class Human {

    private String name;
    private String gender;
    private int id;
    private Human father;
    private Human mother;
    private List<Human> children;


    public Human(String name, String gender, int id, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.id = id;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public boolean addChild(Human child){
        if (children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }
    public Human getMother() {
        return mother;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder () ;
        sb. append ("имя: ");
        sb.append (name) ;
        sb.append(", ");
        sb. append (getMotherInfo());
        sb.append(", ");
        sb.append (getFatherInfo()) ;
        sb.append(", ");
        sb.append (getChildrenInfo ());
        return sb. toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        if (father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get (i) . getName ()) ;
            }
        } else {
            res. append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return "name: " + name + ",id: " + id + ",gender: " + gender;
    }
}
