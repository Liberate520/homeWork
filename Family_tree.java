import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CompareMethods.PersonByGender;
import CompareMethods.PersonByAge;

public class Family_tree implements Serializable, Iterable<Person> {
    
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

    public void sortByGender(){
        familyTree.sort(new PersonByGender<>() );
    }

    public void sortByAge(){
        familyTree.sort(new PersonByAge<>() );
    }

    public String getPersonsInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей:\n");

        for (Person person: familyTree){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(familyTree);
    }


}
