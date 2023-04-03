import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FamilyTree implements Serializable {
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

//    public void addHuman(Human human) {
//        humanList.add(human);
//    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public String getInfo() {
        System.out.println("*".repeat(30));
        StringBuilder tree = new StringBuilder();
        tree.append("В семье ").append(humanList.size())
                .append(" человека").append(" \n");
        for (Human human: this.humanList) {
            tree.append(human.getInfo() + "\n");
        }
        return tree.toString();
    }


    public void save(FamilyTree tree) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("out.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(tree);
        }
        catch (IIOException ex) {
            ex.printStackTrace(System.out);
        }
    }
//
//    @Override
//    public FamilyTree load() throws ClassNotFoundException, InvalidObjectException {
//        try (FileInputStream fis = new FileInputStream("out.txt");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            FamilyTree object = (FamilyTree) ois.readObject();
//            return object;
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        }
//        throw new InvalidObjectException("Object fail");
//    }




}
