import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;

    public FamilyTree(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public Human getHumanByName(String name) {
        if (this.familyTree.isEmpty()) {
            return null;
        } else {
            for (Human human : this.familyTree) {
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
        for (Human human : familyTree) {
            stb.append(human).append("\n");
        }
        return stb.toString();
    }

    public void checkAndAddChildren() {
        if (!this.familyTree.isEmpty()) {
            for (Human humanTemp : familyTree) {
                if (humanTemp.getMother() != null) {
                    Human mother = getHumanByName(humanTemp.getMother().getFullName());
                    mother.getChildren().add(humanTemp);
                }
                if (humanTemp.getFather() != null) {
                    Human father = getHumanByName(humanTemp.getFather().getFullName());
                    father.getChildren().add(humanTemp);
                }
            }
        }
    }

    Iterator<Human> iterator = new Iterator<>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Human next() {
            return null;
        }
    };

    public Iterator<Human> iterator() {
        return familyTree.listIterator();
    }
}