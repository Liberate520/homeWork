import Human.Human;
import tree.FamilyTree;
import tree.comparators.HumanComparatorByDateOfBirth;
import tree.comparators.HumanComparatorByName;

import java.io.*;

public class Service implements  Writeable {
    private final FamilyTree<Human> tree;
    public Service(FamilyTree<Human> tree) {
        this.tree = tree;
    }
    public void sortByName(){
        tree.getTree().sort(new HumanComparatorByName());
    }

    public void sortByDateOfBirht(){
        tree.getTree().sort(new HumanComparatorByDateOfBirth());
    }
    @Override
    public void save(Object o) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data.txt"));
        objectOutputStream.writeObject(o);
        objectOutputStream.close();
    }
    @Override
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data.txt"));
        Object ob = objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(ob);
    }
}
