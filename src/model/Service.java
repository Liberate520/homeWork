package model;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private GenealogyTree<Human> activetree;
    private List<GenealogyTree> genealogyTreeList;
    public Service(GenealogyTree tree) {
        this.activetree = tree;
        genealogyTreeList = new ArrayList<>();
        genealogyTreeList.add((tree));

    }
    public void addHuman(String firstName, String lastName, int age){
        activetree.addHuman(new Human(firstName, lastName, age));
    }


    public Service(){
        this(new GenealogyTree());
    }


    public void addGenealogyTree(GenealogyTree activetree) {
        genealogyTreeList.add(activetree);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (TreeGroupItem human: activetree){
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        activetree.sortByName();
    }

    public void sortByAge(){
        activetree.sortByAge();
    }
}
