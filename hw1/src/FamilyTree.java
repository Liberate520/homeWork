import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Communications> family = new ArrayList<>();

    public List<Communications> getFamily() {
        return family;
    }

    public void setFamily(List<Communications> family) {
        this.family = family;
    }

    public void addRelation(Human h1, Human h2, Relation relation) {
        this.family.add(new Communications(h1, h2, relation));
    }

    @Override
    public String toString() {
        String result = new String();
        for (Communications elem : family) {
            result += elem +"\n";
        }
        return result;
    }
}
