import java.util.List;

public class GenealogyTree {
    private Person root;

    public GenealogyTree(Person root) {
        this.root = root;
    }

    public List<Person> getChildrenOfPerson(Person person) {
        return person.getChildren();
    }
}
