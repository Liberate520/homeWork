import java.util.ArrayList;
import java.util.List;

public class Person extends Human{
    private Human mother;
    private Human father;
    private List<Human> brothersOrSistersList;
    private List<Human> childrens;

    public Person(String firstName, String lastName, int age, Sex sex) {
        super(firstName, lastName, age, Sex.Female);
        this.brothersOrSistersList = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    public Person() {
        this ("NoName", "NoName", 0, Sex.Male);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(super.toString());
        output.append(this.printMother());
        output.append(this.printFather());
        output.append(this.printBrothersOrSisters());
        output.append(this.printChildrens());
        return output.toString();
    }

    public void setMother(String firstName, String lastName, int age) {
        Human mother = new Human(firstName, lastName, age, Sex.Female);
        this.mother = mother;
    }

    public void setFather(String firstName, String lastName, int age) {
        Human father = new Human(firstName, lastName, age, Sex.Male);
        this.father = father;
    }

    public String printMother() {
        StringBuilder output = new StringBuilder();
        if (this.mother != null) {
            output.append("Mother: " + this.mother.getFirstName() + " " + this.mother.getLastName() + "\n");
        }
        return output.toString();
    }

    public String printFather() {
        StringBuilder output = new StringBuilder();
        if (this.father != null) {
            output.append("Father: " + this.father.getFirstName() + " " + this.father.getLastName() + "\n");
        }
        return output.toString();
    }

    public void addBrotherOrSister(String firstName, String lastName, int age, Sex sex) {
        Human brotherOrSister = new Human(firstName, lastName, age, sex);
        this.brothersOrSistersList.add(brotherOrSister);
    }

    public String printBrothersOrSisters() {
        StringBuilder output = new StringBuilder();
        if (this.brothersOrSistersList != null && this.brothersOrSistersList.size() != 0) {
            output.append("Brothers and sisters:" + "\n");
            for (Human person: this.brothersOrSistersList) {
                output.append(person.getFirstName() + " " + person.getLastName() + "\n");
            }
        }
        return output.toString();
    }

    public void addChildren(String firstName, String lastName, int age, Sex sex) {
        Human child = new Human(firstName, lastName, age, sex);
        this.childrens.add(child);
    }

    public String printChildrens() {
        StringBuilder output = new StringBuilder();
        if (this.childrens != null && this.childrens.size() != 0) {
            output.append("Childrens:" + "\n");
            for (Human child: this.childrens) {
                output.append(child.getFirstName() + " " + child.getLastName() + "\n");
            }
        }
        return output.toString();
    }
}
