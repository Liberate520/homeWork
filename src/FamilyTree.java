import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Person> persons;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    private FamilyTree(List<Person> person){
        this.persons = persons;
    }
}
