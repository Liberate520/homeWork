package FamilyTree.model.Service;
import java.io.*;
public class FileHandler implements Writable {
    @Override
    public boolean write(Serializable serializable, String filepath) {
        try (FileOutputStream fout = new FileOutputStream(filepath)){
            ObjectOutputStream stream = new ObjectOutputStream(fout);
            stream.writeObject(serializable);
            return true;
        }
        catch (FileNotFoundException e) { e.printStackTrace(); }
        catch (IOException e) {e.printStackTrace(); }

        return false;
    }

    @Override
    public Object read(String filepath){
        Object ft = null;
        try (FileInputStream fin = new FileInputStream(filepath)){
            ObjectInputStream ois = new ObjectInputStream(fin);
            ft = ois.readObject();
        }
        catch (FileNotFoundException ex) { throw new RuntimeException(ex); }
        catch (ClassNotFoundException ex) { throw new RuntimeException(ex); }
        catch (NullPointerException ex){throw new RuntimeException(ex);}
        catch (IOException ex) { throw new RuntimeException(ex); }
        return ft;
    }
}
