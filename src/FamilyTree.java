
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {


    private List<T> famTree;


    public FamilyTree() {
        this.famTree = (new ArrayList<>());

    }

    public void addHuman(T human) {

        this.famTree.add(human);
        if (human.getFather() != null) {
            human.getFather().getChildList().add(human);
        }
        if (human.getMother() != null) {
            human.getMother().getChildList().add(human);
        }
        if (human.getChildList().size() > 0) {
            for (Human child : human.getChildList()) {
                if (human.getGender().equals("Male")) {
                    child.setFather(human);
                } else if (human.getGender().equals("FeMale")) {
                    child.setMother(human);
                }
            }
        }

    }

    public void addCat(T kot) {
        this.famTree.add((T) kot);
    }


    public String toString() {
        String res = "";
        for (T hum : famTree) {
            res += hum + "\n";
        }
        return res;
    }

    public void printAllTree() {
        System.out.println("Список всех членов дерева");
        String res = "";
        for (T hum : famTree) {
            res += hum + "\n";
        }
        System.out.println(res);
    }

    public T findByName(String name) {
        for (T hum : famTree) {
            if ((hum.getName().equals(name))) {
                return hum;
            }
        }
        return null;
    }

    public String findChild(T hum) {
        return hum.getChildren();
    }

    ;

    public String findParents(T hum) {
        return hum.printParents();
    }


    public List<T> getFamTree() {
        return famTree;
    }

    public List<Human> read() throws IOException, ClassNotFoundException {
        File_interface work = new Files_working();
        famTree = (List<T>) new ArrayList<>(work.read_files());
        return (List<Human>) famTree;

    }

    public void write() throws IOException {
        File_interface work = new Files_working();
        work.write_files((List<Human>) this.famTree);
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(famTree);
    }

    public void sortingByAge() {

        Collections.sort(famTree, new HumanComparatorToAge());
    }

    public void sortingByName() {
        // пришлось добавить компаратор, не хотел котов и людей сортировать

        Collections.sort(famTree, new HumanComparatorName());
    }
}



