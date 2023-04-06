import java.io.FileInputStream;
import java.io.FileOutputStream;

public interface Interf {
    FamilyTree loadFile(String str);
    void saveFile(FamilyTree familyTree, String str);
}
