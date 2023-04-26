package familyTree.saving;

import familyTree.ServiceForTree;

import java.io.*;

public class Serial implements SaveAndLoad {

    private static final long serialVersionUID = 6042495868907328366L;
    public void savingWork(Serializable serial, String pathStr) {
        try (ObjectOutputStream objOS = new ObjectOutputStream(new FileOutputStream(pathStr))){
            objOS.writeObject(serial);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ServiceForTree loadingWork(String pathStr) {
        try (ObjectInputStream objIS = new ObjectInputStream(new FileInputStream(pathStr))){
            return (ServiceForTree) objIS.readObject();
        }
        catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
