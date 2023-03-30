import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class familyTree {
    private List<human> familyTree;

    public familyTree(ArrayList<human> familyTree) {
        this.familyTree = familyTree;
    }

    public human getHumanByName(String name) {
        if (this.familyTree.isEmpty()) {
            return null;
        } else {
            for (human human : this.familyTree) {
                if (human.getFullName().equals(name)) {
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder("Генеалогическое древо состоит из: \n");
        for (human human : familyTree) {
            stb.append(human).append("\n");
        }
        return stb.toString();
    }

    public void checkAndAddChildren() {
        if (!this.familyTree.isEmpty()) {
            for (human humanTemp : familyTree) {
                if (humanTemp.getMother() != null) {
                    human mother = getHumanByName(humanTemp.getMother().getFullName());
                    mother.getChildren().add(humanTemp);
                }
                if (humanTemp.getFather() != null) {
                    human father = getHumanByName(humanTemp.getFather().getFullName());
                    father.getChildren().add(humanTemp);
                }
            }
        }
    }

    Iterator<human> iterator = new Iterator<>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public human next() {
            return null;
        }
    };

    public Iterator<human> iterator() {
        return familyTree.listIterator();
    }
}
