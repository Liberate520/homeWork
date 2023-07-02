package FamilyTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class FamilySerialize {
    private static final String FLODER_PATH = "src\\Data";
    private static final String FILE_NAME = "person.out";

    public static final String FILE_PATH = FLODER_PATH + "\\" + FILE_NAME;

    public static FamilyTree[] DeSerialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        FamilyTree primalTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        Set<FamilyTree> treeSet = new HashSet<FamilyTree>();
        treeSet.add(primalTree);
        for (var person : primalTree.getPersons()) {
            treeSet.add(person.getFamilyTree());
        }
        return treeSet.toArray(new FamilyTree[treeSet.size()]);
    }

    public static void Serialize(FamilyTree tree) throws IOException {
        File folder = new File(FLODER_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(FILE_PATH));
            objectOutputStream.writeObject(tree);
            objectOutputStream.close();
        }
    }

}
