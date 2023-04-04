import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;


public class FamilyTree implements Serializable, Iterable<Human> {
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
        StringBuilder tree = new StringBuilder();
        tree.append("В семье ").append(humanList.size())
                .append(" человека").append(" \n");
        for (Human human: this.humanList) {
            tree.append(human.getInfo() + "\n");
        }
        return tree.toString();
    }

    public void save(List<Human> humanList) throws IOException {
        try (FileOutputStream fos = new FileOutputStream("src/out.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(humanList);
        }
        catch (IIOException ex) {
            ex.printStackTrace(System.out);
        }
    }

        public List<Human> load() throws ClassNotFoundException, InvalidObjectException {
        try (FileInputStream fis = new FileInputStream("src/out.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Human> object = (List<Human>) ois.readObject();
            return object;
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        throw new InvalidObjectException("Object fail");
    }



//    public void save(FamilyTree tree) throws IOException {
//        try (FileOutputStream fos = new FileOutputStream("out.txt");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(tree);
//        }
//        catch (IIOException ex) {
//            ex.printStackTrace(System.out);
//        }
//    }
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

    public boolean saveTree(FamilyTree tree) {
        boolean flag = false;
        File file = new File("tree.txt");
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            if (fos != null) {
                try {
                    oos = new ObjectOutputStream(fos);
                    flag = true;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    public FamilyTree loadTree() throws InvalidObjectException {
        File file = new File("tree.txt");
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis != null) {
                try {
                    ois = new ObjectInputStream(fis);
                    FamilyTree tree = (FamilyTree) ois.readObject();
                    return tree;
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        throw new InvalidObjectException("Object fail");
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }


}
