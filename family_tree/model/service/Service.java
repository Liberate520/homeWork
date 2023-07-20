package family_tree.model.service;

import java.util.ArrayList;
import java.util.List;

import family_tree.model.human_family.FamilyTree;

import family_tree.model.humans.Human;

public class Service<T extends Human> {
    private FamilyTree familyTree;
    private List<T> humans = new ArrayList<>();

    public Service() {
        familyTree = new FamilyTree<>();
        
    }

    public String getHumansInfo() {
        return familyTree.getHumansInfo();

    }

    public void sortByYear() {
        familyTree.sortByYear();
    }

    public void addHuman(T human) {
        humans.add(human);
    }

}
