package family;

import java.io.*;

public class FileHandler {
    FamilyTree familyTree = new FamilyTree();
    String fileName;
   public static void SaveInFile(FamilyTree familyTree, String fileName) throws IOException {
       familyTree = familyTree;
       fileName = fileName;
       ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
       objectOutputStream.writeObject(familyTree);
       objectOutputStream.close();
   }
public static FamilyTree LoadfromFile(String fileName) throws IOException, ClassNotFoundException {
    // Востановление из файла с помощью класса ObjectInputStream
    ObjectInputStream objectInputStream = new ObjectInputStream(
            new FileInputStream(fileName));

    FamilyTree RestoredFamily = (FamilyTree) objectInputStream.readObject();
    objectInputStream.close();

return RestoredFamily;
}
}
