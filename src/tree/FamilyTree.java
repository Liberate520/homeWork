package tree;

import classes.Human;

import java.util.ArrayList;
import java.util.HashSet;

public class FamilyTree {
    private HashSet<Human> tree;

    public FamilyTree() {
        this.tree = new HashSet<>();
    }


    public void replace(Human old, Human newOne){
        this.tree.remove(old);
        this.tree.add(newOne);
    }


    public void addMember(Human member) {
        tree.add(member);
    }


    public ArrayList<Human> getTree() {
        return new ArrayList<>(tree);
    }

//    public ArrayList<Parent> gatTreeParents(){
//        ArrayList<Parent> results = new ArrayList<>();
//        for (Human person : tree) {
//            try {
//                results.add((Parent) person);
//            } catch (Exception e) {
//                System.out.println("Error");
//
//            }
//        }
//        return results;
//    }
}
