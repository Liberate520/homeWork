
import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable {

    ArrayList<Human> familyTree;

    public FamilyTree(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human human) {
        if (!familyTree.contains(human)) {
            familyTree.add(human);
        }
    }

    @Override
    public String toString() {
        return getInformation();
    }

    public String getInformation() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("В семейном дереве %d объектов:\n", familyTree.size()));
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
