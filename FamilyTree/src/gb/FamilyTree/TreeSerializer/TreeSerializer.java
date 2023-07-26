package gb.FamilyTree.TreeSerializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import gb.FamilyTree.TreeSerializer.Interfaces.FileReadable;
import gb.FamilyTree.TreeSerializer.Interfaces.FileWritable;

public class TreeSerializer implements FileReadable, FileWritable {
    private File currentFile;

    public TreeSerializer(File file) {
        this.currentFile = file;
    }

    public TreeSerializer(String filePath) {
        this(new File(filePath));
    }

    public TreeSerializer() {
        this("tree.out");
    }

    @Override
    public void writeToFile(Object objectToWrite) {
        try {
            ObjectOutputStream streamOut = new ObjectOutputStream(new FileOutputStream(this.currentFile, false));
            streamOut.writeObject(objectToWrite);
            streamOut.close();
        } catch (Exception e) {
            System.out.println("Failed to write!");
        }
    }

    @Override
    public Object readFromFile() {
        try {
            ObjectInputStream streamIn = new ObjectInputStream(new FileInputStream(currentFile));
            return streamIn.readObject();
        } catch (Exception e) {
            System.out.println("Failed to read file..");
            return null;
        }
    }
}
