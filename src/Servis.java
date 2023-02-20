import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Servis implements Writable{
    private String filename;


    public Servis(String filename){
        this.filename = filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void save(Serializable serializable) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serializable);
            oos.close();
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        
    }

    @Override
    public FamilyTree read() {
        FamilyTree tree;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            tree = (FamilyTree) ois.readObject();
            ois.close();
            return tree;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
