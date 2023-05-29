package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private GenealogyTree<Human> activetree;
    private List<GenealogyTree> genealogyTreeList;
    Writable writable = new FileHandler();
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

    public void read() throws IOException, ClassNotFoundException {
        String filePath = "src/tree1.txt";
        activetree = (GenealogyTree) writable.read(filePath);
    }
    public void save() throws IOException, ClassNotFoundException {
        String filePath = "src/tree1.txt";
        writable.save(activetree,filePath);;
    }
}
