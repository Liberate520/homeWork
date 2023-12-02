import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FamilyTreeGUI {

    static void getChildren(FamilyTree familyTree, Human human) {
        List<Human> children = new ArrayList<>();
        children = familyTree.findChildren(human);
        System.out.println("This Human:");
        HumanPrint.printHumanFLA(human);
        System.out.println("Has children:");
        HumanPrint.printHumanFLAList(children);
    }

    static void getParrents(FamilyTree familyTree, Human human) {
        Human father = familyTree.findFather(human);
        Human mather = familyTree.findMather(human);
        if (father != null) {
            System.out.println("This Human:");
            HumanPrint.printHumanFLA(human);
            System.out.println("Has father:");
            HumanPrint.printHumanFLA(father);
        }
        if (mather != null) {
            System.out.println("This Human:");
            HumanPrint.printHumanFLA(human);
            System.out.println("Has father:");
            HumanPrint.printHumanFLA(mather);
        }

    }

    static void SaveObject(String filename, FamilyTree familyTree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(familyTree);
            System.out.println("File has been written");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }

    }

    static FamilyTree LoadObject(String filename) {
        FamilyTree tmp = null;
        try (FileInputStream fis = new FileInputStream(filename);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            tmp = (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    static void PrintAll(FamilyTree familyTree) {
        HumanPrint.printHumanFLAList(familyTree.getHumanList());
    }

}