import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Person> tree;

//===================================================================
//Constructors

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList<Person> tree){
        this.tree = tree;
    }

//===================================================================
    

    public void printTree() {
        for (Person person : tree) {
            System.out.println(person);
        }
    }

    public Person getPersonByID(int id){
        for (Person person : tree) {
            if (id == person.getId()) return person;
        }
        System.out.println("There are no people with id - " + id);
        return null;
    }

    public void addPerson(Person person){
        if (person != null){
            tree.add(person);
        }
    }

    public void addPerson(Person person, Person ... parents){
        if (person != null){
            tree.add(person);
            for (Person parent : parents) {
                person.addParent(parent);
                parent.addChild(person);
                if (parent.getSex() == Sex.MALE) person.setLastName(parent.getLastName());
            }
        }
    }

    public void showChildren(Person person){
        if (person != null){
            for (Person child : person.getChildren()) {
                System.out.println(child);            
            }
        }
    }
    public void showParents(Person person){
        if (person != null){
            for (Person parent : person.getParents()) {
                System.out.println(parent);            
            }
        }
    }
    public void showGrandParents(Person person){
        if (person != null){
            for (Person parent : person.getParents()) {
                if (parent.getSex() == Sex.MALE) System.out.println("Paternal grandparents:");
                else System.out.println("Maternal grandparents:");
                showParents(parent);            
            }
        }
    }
}
