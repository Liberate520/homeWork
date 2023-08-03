import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Family_tree implements Serializable{
    
    protected ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    // связь родитель - ребенок
    public void appendPerentChild(Person parent, Person children) {
        tree.add(new Node(parent, Relationship.parent, children));
        tree.add(new Node(children, Relationship.children, parent));
    }
    
        public Family_tree(List<Person> familyTree) {
        this.familyTree = familyTree;
    }


    private List<Person> familyTree;
    public Family_tree() {
        this(new ArrayList<>());
    }

    public void addPerson(Person human) {
        familyTree.add(human);
    }
}
