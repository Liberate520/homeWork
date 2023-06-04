import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name = "none";
    private String birthday;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Gender gender;


    public String getBirthday() {
        return birthday;
    }

    public String getFather() {
        return this.father.name;
    }

    public void setFather(Human father) {
        this.father = father;
        father.children.add(this);
    }

    public String getMother() {
        return this.mother.name;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        mother.children.add(this);
    }

    public void setChild(Human child) {
        this.children.add(child);
        if (this.gender.equals(Gender.male)) {
            child.father = this;
        }
        else child.mother = this;
    }

    public void getParents() {
        System.out.print("Mother: " + this.mother.name + "\n"
                + "Father: " + this.father.name + "\n");
    }


    public List<Human> getChildren() {
        return children;
    }

    public String GetGrandfathers () {
        return "Mother line: \n" + mother.father.toString()
                + "Father line: \n"
                + father.father.toString();
    }
    public String GetGrandmothers () {
        return "Mother line: \n" + mother.mother.toString()
                + "Father line: \n"
                + father.mother.toString();
    }

    public String GetGrandsonsAndGrandDaughters () {
        List<Human> grandsonsAndGrandDaughtersList = new ArrayList<>();
        for (Human human: this.children) {
            grandsonsAndGrandDaughtersList.addAll(human.children);
        }
        return PrintList(grandsonsAndGrandDaughtersList);
    }

    public Human(String name, String birthday, Human mother, Human father, List<Human> children, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.mother = new Human();
        this.father = new Human();
        this.children = new ArrayList<Human>();
        this.gender = gender;
    }

    public Human () {
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Birthday date: " + birthday + '\n' +
                "Mother: " + mother.name + '\n' +
                "Father: " + father.name + '\n' +
                "Children: " + "\n" + PrintList(children);
    }
    public String  PrintList (List<Human> children) {
        int i = 1;
        String childrenList = "";
        for (Human child: children) {
            childrenList += i + ") " + child.name + "\n";
            i++;
        }
        return childrenList;
    }
}
