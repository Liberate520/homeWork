package model.fileClass;

import model.treeWork.ElementTree;

import java.io.*;
import java.util.List;


public class Files_working implements Serializable, File_interface {


    @Override
    public List<ElementTree> read_files() throws IOException, ClassNotFoundException {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("backup"));
        return (List<ElementTree>) in.readObject();
    }

    @Override
    public void write_files(List<ElementTree> fos) throws IOException {

        try {
            FileOutputStream out = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(fos);
            oos.close();
            System.out.println("backup List serialized");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}

