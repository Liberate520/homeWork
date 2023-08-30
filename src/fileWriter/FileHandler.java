package fileWriter;

import FamilyTree.Tree;
import java.io.*;


public class FileHandler implements Writable {
    private String filename;

    public FileHandler (String filename) {
        this.filename= filename;
    }

    public String getFilename() {
        return filename;
    }
    @Override
    public void saveFile(Tree family) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(family);
        out.close();
    }
    @Override
    public Tree loadFile() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Tree tree2 = (Tree) in.readObject();
        return tree2;
    }

}
