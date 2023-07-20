package family_tree;

import family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {

    @Override
    public void saveFile(FamilyTree tree,String path) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(path));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }


}
