import FamilyTree.Tree;

import java.io.*;


public class FileHandler extends Tree implements Writable{
    private String filename;
    Tree stream;

    public FileHandler (String filename, Tree stream) {
        this.filename= filename;
        this.stream = stream;
    }
    public String getFilename() {
        return filename;
    }

    public void saveFile() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        out.writeObject(stream);
        out.close();
    }

    public Tree loadFile() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Tree tree2 = (Tree) in.readObject();
        return tree2;
    }

}


