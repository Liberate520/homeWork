import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FamilyTree implements FileProcessing, Serializable{
   private List<Human> familyTree;
    public FamilyTree(List<Human> familyTree){
        this.familyTree = familyTree;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addFamilyTree( Human human) {
        if (!familyTree.contains(human)) {
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            this.familyTree.add(human);
        }
    }

    @Override
    public void read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        FamilyTree tree =  (FamilyTree)in.readObject();
        familyTree = tree.familyTree;
    }

    @Override
    public void save(String fileAddress) throws IOException  {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(this);
        out.close();
    }
}
