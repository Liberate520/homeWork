package family_tree.model.service;

import family_tree.model.human_family.FamilyTree;
import family_tree.model.human_family.HumanItem;
import family_tree.model.humans.Human;

public class Service {
    private FamilyTree familyTree;

    public Service() {
        familyTree = new FamilyTree<>();
    }

    public String getHumansInfo() {
        return familyTree.getHumanInfo();

    }

    public void sortByYear() {
        familyTree.sortByYear();
    }

    public void addHuman(Human human) {
        familyTree.addHuman((HumanItem) human);
    }

}
