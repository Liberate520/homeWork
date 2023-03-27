import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> people;

    public FamilyTree(List<Human> people) {
        this.people = people;
    }
    
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addpeople(Human h) {
        people.add(h);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(this.people);
        return str.toString();
    }
}
