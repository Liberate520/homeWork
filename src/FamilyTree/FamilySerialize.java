package FamilyTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FamilySerialize {
    private static final String FLODER_PATH = "src\\Data";
    private static final String FILE_NAME = "person.out";

    public static final String FILE_PATH = FLODER_PATH + "\\" + FILE_NAME;

    public static FamilyTree[] deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        FamilyTree primalTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        Set<FamilyTree> treeSet = new HashSet<FamilyTree>();
        treeSet.add(primalTree);
        Queue<FamilyTree> queue = new LinkedList<>();
        queue.add(primalTree);
        while (!queue.isEmpty()) {
            for (var person : primalTree) {
                var currentTree = person.getFamilyTree();
                if (currentTree != null) {
                    treeSet.add(currentTree);
                    queue.add(currentTree);
                }
            }
        }
        return treeSet.toArray(new FamilyTree[treeSet.size()]);
    }

    public static void serialize(FamilyTree tree) throws IOException {
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