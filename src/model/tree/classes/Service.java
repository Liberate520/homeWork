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

    public void setHuman(Human human){
        SetHuman setHuman = new SetHuman();
        setHuman.settingHuman(human);      
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

    public void saveTree(){
        tree.save("src/model/storages/Test.out");
    }

    public void loadTree(){
        tree.load("src/model/storages/Test.out");
    }
}
