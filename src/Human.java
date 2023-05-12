import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable{
    private String name;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }
    public Human(String name, Gender gender) {this(name, gender, null, null);}

    public boolean addChild(Human child){
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName(){return name;}
    public Human getFather(){return father;}
    public Human getMother(){return mother;}
    public Gender getGender(){return gender;}
    public List<Human> getChildren(){return children;}
    public void setFather(Human father){this.father = father;}
    public void setMother(Human mother){this.mother = mother;}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getChildrenInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("дети: ");
        if (children.size() != 0) {
            sb.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                sb.append(", ");
                sb.append(children.get(i).getName());
            }
        }else {
            sb.append("отсуствуют");
        }
        return sb.toString();
    }

    public String getFatherInfo() {
        String res = "отец: ";
        if (father != null) {
            res += father.getName();
        }else {
            res += "неизвестен";
        }
        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        if (mother != null) {
            res += mother.getName();
        }else {
            res += "неизвестна";
        }
        return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}