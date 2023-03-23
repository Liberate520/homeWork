package familytree.serializer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;

public class FamilyTreeSerializer implements IFamilyTreeSerializer {

    public boolean save(Object familyTree) {
        try (var outStream = new ObjectOutputStream(new FileOutputStream("family_tree.dat"))) {
            outStream.writeObject(familyTree);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public FamilyTree<FamilyTreeMemeber> load() {
        try (var inpStream = new ObjectInputStream(new FileInputStream("family_tree.dat"))) {
            return (FamilyTree<FamilyTreeMemeber>) inpStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }

}
