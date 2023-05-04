package familyTree.model.saving;

import familyTree.model.ServiceHuman;

import java.io.*;

public class Serial implements SaveAndLoad {

    private static final long SerialVersionUID = 6042495868907328366L;
    public void savingWork(Serializable serial, String pathStr) {
        try (ObjectOutputStream objOS = new ObjectOutputStream(new FileOutputStream(pathStr))){
            objOS.writeObject(serial);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ServiceHuman loadingWork(String pathStr) {
        try (ObjectInputStream objIS = new ObjectInputStream(new FileInputStream(pathStr))){
            return (ServiceHuman) objIS.readObject();
        }
        catch (ClassNotFoundException | IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
