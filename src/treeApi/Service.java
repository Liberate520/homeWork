package src.treeApi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {
    private int id;
    private FamilyTree<Human> tree;
    String res = "";

    public Service(FamilyTree<Human> familyTree){
        this.tree = familyTree;
    }

    public String get(){
        
        for (Human human : tree) {
            res = res + human.getName()+"\n";
        }
        return res;
    }

    public String find(String name){
        for (Human human : tree) {
            if(human.getName().equals(name)){
                return human.getInfo();
            }
        }
        return null;
    }

    public void add(String name, Human father, Human mother) {
        Human human = new Human(++id, name, father, mother);
        tree.add(human);
    }
    public void add(String name) {
        Human human = new Human(++id, name);
        tree.add(human);
    }

    public String getInfo() {
        for (Human string : tree) {
            res = res + string.getInfo() + "\n";
        }
        return res;
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
