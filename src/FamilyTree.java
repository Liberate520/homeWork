import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class FamilyTree implements Serializable {
    List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addPerson (Human human) {
        this.familyTree.add(human);
    }

    public void save(Serializable obj, String filePath) throws IOException {
        FileHandler.save(obj, filePath);
    }

    public Serializable load(String filePath) throws IOException, ClassNotFoundException {
        return FileHandler.load(filePath);
    }
}
