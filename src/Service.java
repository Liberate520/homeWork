
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree<Human> activeTree;
    private List<Human> familyTree;
    

    public Service(FamilyTree tree) {
        this.activeTree = tree;
        familyTree = new ArrayList<>();
        familyTree.add(tree);
    }
    public Service(){
        this(new FamilyTree());
    }

    public void addFamilyTree(FamilyTree familyTree){
        familyTree.add(familyTree);
    }

    public void addHuman(int id, String name, String string, String string2, Gender male){
        activeTree.addHuman(new Human(id, name, null, null, null));
    }

    // public void add(String name, String surname, String dateOfBirth, Gender gender) {
    //     Human human = new Human(++id, name, surname, dateOfBirth, gender, null, null, null);
    // }

    public void sortByName() {
        activeTree.sortByName();
    }

    public void sortById() {
        activeTree.sortById();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();


        for (Human human: activeTree){
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
}