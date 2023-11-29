import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    Human human;
    List<Human> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public boolean addHumanInTree(Human human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            return true;
        }
        return false;


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!(familyTree.isEmpty())) {
            for (Human human : familyTree) {
                    sb.append(human.getName() + " Дата рождения: " + human.getLd() +"\n");
                    if(human.getChild() != null){
                        sb.append("Дети: " +"\n"+ human.getChild() +  "\n");
                    }
            }
        }
        return sb.toString();
    }
}
