package familyTree;

import human.Animal;
import human.Human;

import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FamilyTree<E extends Animal<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;

    private String name;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public E getByName(String name) {
        for (E human :
                humanList) {
            if (human.getName().equals(name))
                return human;
        }
        return null;
    }

    public E getBySurname(String surname) {
        for (E human :
                humanList) {
            if (human.getSurname().equals(surname))
                return human;
        }
        return null;
    }

    public void addHuman(E human) {
        humanList.add(human);
    }

    public boolean add(E human) {
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
        tree.append("В дереве ").append(humanList.size())
                .append(" человек(а)").append(" \n");
        for (E human: this.humanList) {
            tree.append(human.getInfo() + "\n");
        }
        return tree.toString();
    }
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

//    public void save(List<Human> humanList) throws IOException {
//        try (FileOutputStream fos = new FileOutputStream("src/out.txt");
//             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//            oos.writeObject(humanList);
//        }
//        catch (IIOException ex) {
//            ex.printStackTrace(System.out);
//        }
//    }
//
//        public List<Human> load() throws ClassNotFoundException, InvalidObjectException {
//        try (FileInputStream fis = new FileInputStream("src/out.txt");
//             ObjectInputStream ois = new ObjectInputStream(fis)) {
//            List<Human> object = (List<Human>) ois.readObject();
//            return object;
//        } catch (IOException ex) {
//            ex.printStackTrace(System.out);
//        }
//        throw new InvalidObjectException("Object fail");
//    }






}
