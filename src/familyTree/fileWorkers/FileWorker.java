package familyTree.fileWorkers;

import java.io.*;


public class FileWorker implements FileWorkable {

    public boolean saveFile(Serializable serializable,String filePath) {
        try(ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            data.writeObject(serializable);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public Object readFile(String filePath) {
        try(ObjectInputStream data = new ObjectInputStream(new FileInputStream(filePath)))
        {
            return data.readObject();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
