package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree tree;

    public Service(FamilyTree familyTree){
        this.tree = familyTree;
    }

    public void add(String name, Human father, Human mother) {
        Human human = new Human(++id, name, father, mother);
        tree.add(human);
    }
    public void add(String name) {
        Human human = new Human(++id, name);
        tree.add(human);
    }
   
    public List sortByName() {
        ArrayList<Human> list = new ArrayList<Human>(tree.getTree());
        list.sort(new HumanComparatorByName());
        return list;
       
    }

    public List sortById() {
        ArrayList<Human> list = new ArrayList<Human>(tree.getTree());
        list.sort(new HumanComparatorBYId());
        return list;
    }
}
