import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class FileInteraction implements Saveable{

    Serializable s;

    public FileInteraction(Serializable s){
        
    }

    @Override
    public void Save(String path) {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(path));
            ous.writeObject(s);
            ous.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Serializable Load(String path) {
        ObjectInputStream ois = null;
        Tree s = new Tree();

        try {
            ois = new ObjectInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            s = (Tree) ois.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return s;
    }
    
}
