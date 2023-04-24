import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private String dob;
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();

    public Human(String firstName, String lastName, String dob) {
        this(firstName, lastName, dob, null, null);
    }


    public Human(String firstName, String lastName, String dob, Human father, Human mother) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.father = father;
        this.mother = mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChild(List<Human> child) {
        this.children = child;
    }

    public Human getFather() { return father; }

    public Human getMother() { return mother; }

    public List<Human> getChildren() { return children; }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof Human)) return false;
        Human human = (Human) obj;
        return human.getFull().equals(getFull());
    }

    public void addChild(Human human) {
        children.add(human);
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ");
        sb.append(getFullName());
        sb.append(",");
        sb.append(getMotherInfo());
        sb.append(",");
        sb.append(getFatherInfo());
        sb.append(",");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getMotherInfo(){
        String res = " mother: ";
        if (mother != null){
            res += mother.getFullName();
        } else {
            res += "null";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = " father: ";
        if (father != null){
            res += father.getFullName();
        } else {
            res += "null";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append(" childrens: ");
        if (children.size() != 0){
            res.append(children.get(0).getFullName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getFullName());
            }
        } else {
            res.append("null");
        }
        return res.toString();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFull() {
        return firstName + lastName + dob;
    }
}
