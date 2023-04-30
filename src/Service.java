import FamilyTree.FamilyTree;
import human.Human;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree activeTree;
    private List<FamilyTree> familyTreeList;
    public Service(FamilyTree tree){
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }

    public void addHuman(Human human){
        activeTree.addHuman(human);
    }

    public Service(){
        this(new FamilyTree());
    }

    public void addFamilyTreeList(FamilyTree activeTree){
        familyTreeList.add(activeTree);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Object human: activeTree){
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByFirstName(){
        activeTree.sortByFirstName();
    }

    public void sortByLastName(){
        activeTree.sortByLastName();
    }
}
