import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

interface IFamilyTreeSaver {
    boolean save(FamilyTree familyTree);
}

interface IFamilyTreeLoader {
    FamilyTree load();
}

class FamilyTreeSerializer implements IFamilyTreeSaver, IFamilyTreeLoader {

    public boolean save(FamilyTree familyTree) {
        try (var outStream = new ObjectOutputStream(new FileOutputStream("family_tree.dat"))) {
            outStream.writeObject(familyTree);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public FamilyTree load() {
        try (var inpStream = new ObjectInputStream(new FileInputStream("family_tree.dat"))) {
            return (FamilyTree) inpStream.readObject();
        } catch (Exception e) {
            return null;
        }
    }

}