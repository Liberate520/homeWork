package tree;

public class Service {
   // private int id;
    private Tree tree;

    public Service(Tree tree) {
        this.tree = tree;
    }

    public void addHuman(String name, Gender gender) {
        Human human = new Human(name, gender);
        tree.setFamily(human);
    }
     public void sortByName() {
        tree.getFamilyTree().sort(new HumanComparatorByName());
     }

     public void sortByChild() {
        tree.getFamilyTree().sort(new HumanComparatorByChildCount());
     }
}
