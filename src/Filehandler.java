import java.io.*;

public class Filehandler {
    FamilyTree familyTree = new FamilyTree();
    String fileName;
   public static void SaveInFile(FamilyTree familyTree, String fileName) throws IOException {
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
       objectOutputStream.writeObject(familyTree);
       objectOutputStream.close();
   }
public static FamilyTree LoadfromFile(String fileName) throws IOException, ClassNotFoundException {
    ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream(fileName));

    FamilyTree RestoredFamily = (FamilyTree) objectInputStream.readObject();
    objectInputStream.close();

return RestoredFamily;
}
}