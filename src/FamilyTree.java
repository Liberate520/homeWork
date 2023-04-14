import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FamilyTree {
    private HashMap<Relation, Human> relatives;
    private List<HashMap<Relation, Human>> persons;


    public FamilyTree (){
        this.persons = new ArrayList<>();
    }

    public void pushToTree (Person person) {
        this.relatives = new HashMap<>();
        this.relatives.put(Relation.Person, (Human) person);
        this.persons.add(relatives);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        // todo: сделать вывод
        return output.toString();
    }
}
