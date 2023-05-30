import java.util.ArrayList;
import java.util.List;

public class Human {
    private Gender gender;
    private Human mather;
    private Human father;
    private Human name;
    private List<Human> children;
   

    public Human(Gender gender, Human name, Human mather, Human father, List<Human> children) {
        this.gender = gender;
        this.name = name;
        this.mather = mather;
        this.father = father;
        children = new ArrayList<>();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setName(Human name) {
        this.name = name;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Name: " + this.name + "\n");
        output.append("Gender: " + this.gender + "\n");
        output.append("Mather: " + this.mather + "\n");
        output.append("Father: " + this.father + "\n");
        output.append("children: " + this.children + "\n");
        return output.toString();
    }

}
