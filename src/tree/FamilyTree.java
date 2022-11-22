package tree;

import classes.Parent;

import java.util.ArrayList;
import java.util.HashSet;

public class FamilyTree {
    private ArrayList<Parent> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }


    public void replace(Parent old, Parent newOne){
        this.tree.remove(old);
        this.tree.add(newOne);
    }


    public void addMember(Parent member) {
        tree.add(member);
    }


    public ArrayList<Parent> getTree() {
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
