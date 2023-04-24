import famalyTree.Tree;
import human.Gender;
import human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private int id;
    private Tree tree;
    private List<Tree> trees;
    private Writable writable;
    public Service(Tree tree){
        this.tree = tree;
        trees = new ArrayList<>();
        trees.add(tree);
    }
    public Service(){
        this(new Tree());
    }
    public void addTrees(Tree tree){
        trees.add(tree);
    }

    public void addHuman(String name, int yearOfBirth, Gender gender){
        tree.add(new Human(id++, name, yearOfBirth, gender));
    }
    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Human> iterator = tree.iterator();
        while (iterator.hasNext()){
            Human human = iterator.next();
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }
    public void sortByName(){
        tree.sortByName();
    }
    public void sortByAge(){
        tree.sortByAge();
    }
}
