import java.util.ArrayList;
import java.util.List;

public class Service {    
    private FamilyTree<Human> activeTree;
    private List<FamilyTree<Human>> familyTreeList;
    

    public Service(FamilyTree<Human> tree) {
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }
    public Service(){
        this(new FamilyTree<Human>());
    }

    public void addFamilyTree(FamilyTree<Human> familyTree){
        familyTreeList.add(familyTree);
    }

    public void addHuman(int id, String name, String string, String string2, Gender male) {
        activeTree.addHuman(new Human(id, name, null, null, null));
    }
    
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