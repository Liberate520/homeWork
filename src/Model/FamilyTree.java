package Model;
import java.util.ArrayList;

import Presenter.Presenter;



public class FamilyTree<T> {
    private ArrayList<T> tree = new ArrayList<>();
    Presenter pr; 


    public FamilyTree(String path){
        this.tree = new Loader().load_tree(path);
    }

    public ArrayList<T> getTreeList() {
        return tree;
    }

    public static void getChildren(int id, ArrayList<Instance> base) {
        Instance person = base.get(id);
        ArrayList<Instance> children = new ArrayList<>();
        for (Instance person_check : base) {
            if (person_check.getFather_id() == id || person_check.getMother_id() == id)
            {
                children.add(person_check);
            }
        }
        System.out.println("\n Список детей " + person.getName());
        for (Instance person2 : children) {
            System.out.println(person2.getName());
        }
    }

    public static void getKins(int id, ArrayList<Instance> base) {
        Instance person = base.get(id);
        ArrayList<Instance> kins = new ArrayList<>();
        for (Instance person_check : base) {
            if (person_check.getFather_id() != -1 && person_check.getFather_id() == person.getFather_id())
            {
                kins.add(person_check);
            }
        }
        System.out.println("\n Список сестер/братьев " + person.getName());
        for (Instance person2 : kins) {
            System.out.println(person2.getName());
        }
    }
}

