import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private static List<Person> familyTree;

    public FamilyTree(List<Person> person){
        this.familyTree = person;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addPerson(Person person){
        familyTree.add(person);
    }

    public static void getFamilyTree(){
        System.out.println(familyTree);
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }

    public static FamilyTree FamilyTree() {
        return null;
    }
}
