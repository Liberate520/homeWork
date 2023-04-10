import TreeFamily.TreeFamily;
import human.Human;
import human.HumanComporatorByName;

import java.io.IOException;
import java.util.Collections;

public class Service {
//    private int id;
    private  TreeFamily tree;

    public Service(TreeFamily tree) {
        this.tree = tree;
    }

    public void addHuman(String family, String name){
        tree.add(new Human(family, name));

    }

//    public void sortByName(){
//        group.getStudentList().sort(new StudentComparatorByName());
//    }
//
//    public void sortById(){
//        group.getStudentList().sort(new StudentComparatorById());
//    }
    public void sortByFamily(){
        //tree.getList().sort();
        Collections.sort(tree.getList());


    }
    public void sortByName(){
        tree.getList().sort(new HumanComporatorByName());
        //Collections.sort(tree.getList(), new human.HumanComporatorByName());

    }
    public void save(Writable writable) throws IOException {
        writable.save(this);

    }
}
