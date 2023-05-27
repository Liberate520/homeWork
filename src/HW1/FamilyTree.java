package HW1;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;


    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    /**
     * Добавляет связь ребенка и родителя. После выполнения у родителя и ребенка в классе появится необходимая ветвь.
     *
     * @param parent
     * @param child
     */
    public void addBranchParentChild(Human parent, Human child) {
        if (child.getFather() == null) {
            child.setFather(parent);
            if (!checkChildByName(parent, child)) {
                parent.addChild(child);
            }
        } else {
            child.setMother(parent);
            if (!checkChildByName(parent, child)) {
                parent.addChild(child);
            }


        }
    }

    /**
     * Проверяет есть ли ребенок с переданным именем, в списке детей класса Human
     *
     * @param parent
     * @param child
     * @return
     */
    private boolean checkChildByName(Human parent, Human child) {
        for (Human child_ : parent.getChildren()
        ) {
            if (child_.getName().equalsIgnoreCase(child.getName())) return true;
        }
        return false;
    }

    public void addPersonInFamilyTree(Human person) {
        familyTree.add(person);
    }

    public void addPersonInFamilyTree(Human child, String parent) {
        addBranchParentChild(getPerson(parent), child);
        familyTree.add(child);
    }

    public void addPersonInFamilyTree(Human child, String fatherName, String motherName) {
        addBranchParentChild(getPerson(fatherName), child);
        addBranchParentChild(getPerson(motherName), child);
        familyTree.add(child);
    }

    public Human getPerson(String person) {

        for (Human person_ : familyTree
        ) {
            if (person_.getName().equals(person)) return person_;
        }
        return null;
    }

}
