package DZ1.Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import DZ1.FileOperations.FileHandler;
import DZ1.FileOperations.Writable;
// import DZ1.app.Presenter;

public class FamilyTreeOperator<T extends Human> implements Serializable {
    private Writable writable;
    private FamilyTree familyTree;
    // FileHandler fileHandler;
    // private Presenter presenter;

    public FamilyTreeOperator(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public void loadTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        addList((List<T>) writable.read());
    }

    public void saveTree(List<Human> list) throws IOException {
        if (writable != null) {
            writable.save(list);
        }
    }

    public void clearTree() {
        List<T> humans = familyTree.getHumans();
        humans.clear();
        familyTree.setHumans(humans);
    }

    public void sortByName() {
        List<T> humans = familyTree.getHumans();
        Collections.sort(humans);
        familyTree.setHumans(humans);
    }

    public void add(T human) {
        List<T> humans = familyTree.getHumans();
        humans.add(human);
        familyTree.setHumans(humans);
    }

    public void sortByGender() {
        List<T> humans = familyTree.getHumans();
        Collections.sort(humans, new HumanComparatorByGender());
        familyTree.setHumans(humans);
    }

    public void addList(List<T> read) {
        List<T> humans = familyTree.getHumans();
        humans.addAll(read);
        familyTree.setHumans(humans);
    }

    public String getHumanByNameAndRelatives(String name) {
        List<T> humans = familyTree.getHumans();
        String personName = null;
        T person = null;
        for (T human : humans) {
            if (human.getName().equals(name)) {
                personName = human.getName();
                person = human;
            }
        }
        return "Имя: " + personName + ", Отец: " + person.getFather() + ", Мать: " + person.getMother() + ", Дети: "
                + person.getChildren() + ", Братья и сестры: " + person.getBrothersOrSisters();
    }

}
