import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;


enum Gender{
    MAN,
    WOMAN
}
public class Human implements Serializable{
    private String name;
    private Gender gend;
    private int yearBirth;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, Gender gend, int yearBirth, Human father, Human mother) {
        this.name = name;
        this.gend = gend;
        this.yearBirth = yearBirth;
        children = new ArrayList<>();
        this.father = father;
        this.mother = mother;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Gender getGend() {
        return gend;
    }

    public void setGend(Gender gend) {
        this.gend = gend;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
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

    @Override
    public String toString() {
        String gender = "";
        if(gend == Gender.MAN) {
            gender = "male";
        }
        else {
            gender = "female";
        }
        String res = "\n" + name + ", " + gender  + ", " + yearBirth + "";
        if(father != null) {
            res = res + ", father: " + father.getName();
        }
        if(mother != null) {
            res = res + ", mother: " + mother.getName();
        }
        return res;
    }
}
