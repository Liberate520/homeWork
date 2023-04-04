package fileWork;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import group.Groupable;

public class FilehandlerOS implements Writeable {

    @Override
    public void SaveToFile(Groupable groupList, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(groupList);
            System.out.printf("File " + filename + " has been written.\n");
            oos.flush();
            oos.close();
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public Groupable LoadFromFile(String filename) {
        Groupable groupList=null;
        try (
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            groupList = ((Groupable) ois.readObject());
            System.out.printf("File " + filename + " has been loaded.\n");
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return groupList;
    }

}
