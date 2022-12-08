import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Communication>, Print{
    private List<Communication> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    public List<Communication> getFamily() {
        return family;
    }

    public void setFamily(List<Communication> family) {
        this.family = family;
    }
    
    public void addRelation(Essence h1, Essence h2, Relation relation) {
        this.family.add(new Communication(h1, h2, relation));
    }

    @Override
    public String toString() {
        String result = new String();
        for (Communication elem : family) {
            result += elem +"\n";
        }
        return result;
    }

    @Override
    public Iterator<Communication> iterator() {
        return new FamilyTreeIterator(family);
    }
}
