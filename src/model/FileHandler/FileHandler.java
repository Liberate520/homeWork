package FileHandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import FamiliTree.FamilyTree;



public class FileHandler implements Writable{
    private String path;

    public FileHandler() {
        this.path = "src/model/FileHandler/Externals.out";
    }

    public String getPath(){
        return this.path;
    }

    public void save(Object object) throws FileNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getPath()));
        out.writeObject(object);
        out.close();
    }

    @Override
    public Object load() throws FileNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(getPath()));
        try {
            return (FamilyTree) in.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
