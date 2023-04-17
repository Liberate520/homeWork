import java.util.List;

public class Human {
    private Gender gender;
    private Human mather;
    private Human father;
    private List<Human> children;
    private Human firstName;
    private Human lastName;

    public Human(Gender gender, Human firstName, Human lastName, Human mather, Human father, List<Human> children) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mather = mather;
        this.father = father;
        this.children = children;
    }

    public Human(Gender male, String firstName, String lastName, Object mather, Object father, List<Human> children1) {
    }

    public String getInformation() {
        return toString();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFirstName(Human firstName) {
        this.firstName = firstName;
    }

    public void setLastName(Human lastName) {
        this.lastName = lastName;
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
        output.append("Name: " + this.firstName + " " + this.lastName + "\n");
        output.append("Gender: " + this.gender + "\n");
        output.append("Mather: " + this.mather + "\n");
        output.append("Father: " + this.father + "\n");
        output.append("children: " + this.children + "\n");
        return output.toString();
    }

}
