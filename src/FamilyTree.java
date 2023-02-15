import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Human> tree;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList<Human> tree){
        this.tree = tree;
    }

    public void printTree() {
        for (Human person : tree) {
            System.out.println(person);
        }
    }

    public Human getPersonByID(int id){
        for (Human person : tree) {
            if (id == person.getId()) return person;
        }
        System.out.println("There are no people with id - " + id);
        return null;
    }

    public void addPerson(Human person){
        if (person != null){
            tree.add(person);
        }
    }

    public void addPerson(Human person, Human ... parents){
        if (person != null){
            tree.add(person);
            for (Human parent : parents) {
                person.addParent(parent);
                parent.addChild(person);
                if (parent.getSex() == Gender.MALE) person.setLastName(parent.getLastName());
            }
        }
    }

    public void showChildren(Human person){
        if (person != null){
            for (Human child : person.getChildren()) {
                System.out.println(child);            
            }
        }
    }
    public void showParents(Human person){
        if (person != null){
            for (Human parent : person.getParents()) {
                System.out.println(parent);            
            }
        }
    }
    public void showGrandParents(Human person){
        if (person != null){
            for (Human parent : person.getParents()) {
                if (parent.getSex() == Gender.MALE) System.out.println("Paternal grandparents:");
                else System.out.println("Maternal grandparents:");
                showParents(parent);            
            }
        }
    }
}