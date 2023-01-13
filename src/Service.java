import java.io.*;
import java.util.Collections;
import java.util.Map;

public class Service implements Writable, Serializable {
    private Family family;

    public Service(Family family) {
        this.family = family;
    }

    public void sortByName() {
        Collections.sort(family.getMembers());
    }

    public void sortByYearBirth() {
        Collections.sort(family.getMembers(), new HumanComparatorYearBirth());
    }


    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("family.dat"))) {
            oos.writeObject(serializable);
             System.out.println("Saved");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Family read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("family.dat"))) {
            return (Family) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
