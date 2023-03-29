import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> familytree;

    public FamilyTree(List<Person> person){
        this.familytree = person;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addPerson(Person person){
        familytree.add(person);
    }

    @Override
    public String toString() {
        return familytree.toString();
    }
}
