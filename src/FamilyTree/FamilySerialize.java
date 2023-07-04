package FamilyTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FamilySerialize {
    private static final String FLODER_PATH = "src\\Data";
    private static final String FILE_NAME = "person.out";

    public static final String FILE_PATH = FLODER_PATH + "\\" + FILE_NAME;

    public static FamilyTree deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream(FILE_NAME));
        FamilyTree primalTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return primalTree;
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