import java.io.FileInputStream;
import java.io.FileOutputStream;

public interface Interf<E> {
    FamilyTree loadFile(String str);
    void saveFile(FamilyTree familyTree, String str);
}
