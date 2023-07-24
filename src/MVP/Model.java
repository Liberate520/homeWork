package MVP;

import Models.FamilyTree.FamilyTree;
import Models.FamilyTree.Node;
import Models.Relation.Relation;
import Models.Relation.RelationType;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Model<E extends Comparable<E>> {
    private final ArrayList<FamilyTree<E>> trees;

    public Model() {
        this.trees = new ArrayList<>();
    }


    //region TreesManagement

        public ArrayList<FamilyTree<E>> getTrees() {
            return trees;
        }

        public boolean addFamilyTree(String name) {
            if (trees.stream().anyMatch(x -> x.getTreeName().equals(name))) {
                return false;
            }
            trees.add(new FamilyTree<>(name));
            return true;
        }

        public boolean removeFamilyTree(FamilyTree<E> tree) {
            if (trees.stream().noneMatch(x -> x.equals(tree))) {
                return false;
            }
            trees.remove(tree);
            return true;
        }

        public FamilyTree<E> getFamilyTree(String name) {
            if (trees.stream().noneMatch(x -> x.getTreeName().equals(name))) {
                return null;
            }
            return trees.stream().filter(x -> x.getTreeName().equals(name)).collect(Collectors.toList()).get(0);
        }

        public boolean renameFamilyTree(String oldName, String newName) {
            if (trees.stream().anyMatch(x -> x.getTreeName().equals(oldName))) {
                return false;
            }
            trees.stream().filter(x -> x.getTreeName().equals(oldName)).collect(Collectors.toList())
                    .get(0).setTreeName(newName);
            return true;
        }

    //endregion
}
