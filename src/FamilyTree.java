
import java.io.IOException;
import java.io.Serializable;
import java.util.*;


public class FamilyTree implements Serializable, Iterable <Human>{



    private List<Human> famTree;

    public FamilyTree(List<Human> Tree) {
        this.famTree = Tree;
    }

    public FamilyTree() {
        this.famTree = (new ArrayList<>());

    }


    public void addHuman(Human human) {

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


    @Override
    public String toString() {
        String res = "";
        for (Human hum : famTree) {
            res += hum + "\n";
        }
        return res;
    }

    public void printAllTree() {
        System.out.println("Список всех членов дерева");
        String res = "";
        for (Human hum : famTree) {
            res += hum + "\n";
        }
        System.out.println(res);
    }

    public Human findByName(String name) {
        for (Human hum : famTree) {
            if ((hum.getName().equals(name))) {
                return hum;
            }
        }
        return null;
    }

    public String findChild(Human hum) {
        return hum.getChildren();
    }

    ;

    public String findParents(Human hum) {
        return hum.printParents();
    }


    public List<Human> getFamTree() {
        return famTree;
    }

    public List<Human> read() throws IOException, ClassNotFoundException {
        File_interface work = new Files_working();
        famTree = new ArrayList<>(work.read_files());
        return famTree;

    }

    public void write() throws IOException {
        File_interface work = new Files_working();
        work.write_files(this.famTree);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(famTree);
    }
    public void sortingByAge(){

         Collections.sort(famTree, new HumanComparatorToAge());
}
    public void sortingByName(){

         Collections.sort(famTree);
    }
}



