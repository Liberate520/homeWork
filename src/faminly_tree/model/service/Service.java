package faminly_tree.model.service;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.Human;
import faminly_tree.model.tree.FamiliItem;
import faminly_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {

    private FamilyTree tree;

    public Service() {
        this.tree = new FamilyTree<>();
    }

    public void addHuman(String name, Gender gender, LocalDate birth){
        Human human = new Human(name, gender, birth);
        tree.addToTree(human);
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void showAllTree() {
        System.out.println(tree);
    }

    public void connection(int parentID, int childID){
        ((Human)tree.getHumanByID(childID)).childFor((Human)tree.getHumanByID(parentID));
    }
}
