package HW_5;


import java.io.*;

public class inOutSerialObject implements InOutFiles, Serializable {

    public  FamilyTree  loadFile(String str) {
        FamilyTree familyTree = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(str))) {
            familyTree = (FamilyTree) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return familyTree;
    }

    public  void saveFile(FamilyTree familyTree, String str) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(str))) {
            oos.writeObject(familyTree);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}


