import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FamilyTree implements Writable {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public Human getByName(String name) {
        for (Human human :
                humanList) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }

    public Human getBySurname(String surname) {
        for (Human human :
                humanList) {
            if (human.getSurname().equals(surname))
                return human;
        }
        return null;
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }

   public String getInfo() {
       System.out.println("*".repeat(30));
       StringBuilder tree = new StringBuilder("Семья: \n");
       for (Human human: this.humanList) {
           tree.append(human + "\n");
       }
       return tree.toString();
    }

    @Override
    public void save(Writable serializable) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("out.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(serializable);
        }
        catch (IIOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public Writable load() throws ClassNotFoundException, InvalidObjectException {
        try (FileInputStream fis = new FileInputStream("out.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Writable object = (FamilyTree) ois.readObject();
            return object;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        throw new InvalidObjectException("Object fail");
    }
}
