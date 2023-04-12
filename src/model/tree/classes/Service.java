package model.tree.classes;

import java.util.List;

public class Service {
    private Tree tree;

    public Service(){
        tree = new Tree<Human>();
    }

    public List<Human> getTree(){
        return tree.getTree();
    }

    public void addPerson(Human person){
        tree.addPerson(person);
    }

    public List<Human> serachPerson(String str){
        return tree.searchPerson(str);
    }

    public String treeToString(){
        return tree.treeToString();
    }
}
