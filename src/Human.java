import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private Human mother;
    private Human father;

    public Human(String firstName, String lastName, Human mother, Human father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mother = mother;
        this.father = father;
    }

    public Human getMother() {

        return mother;
    }

    public Human getFather() {
        return father;
    }


    public List<Human> getChildren(){
        List<Human> children = new ArrayList<>();
        for (Human child: FamilyThree.getHumans()) {
            if ((child.getMother() == this) || (child.getFather() == this)) {
                children.add(child);
            }
        }
        return children;
    }
    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }


}
