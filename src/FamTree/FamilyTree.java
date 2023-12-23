package FamTree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T> implements Serializable {

    public ArrayList<Human>persons;
    public ArrayList<NodeFamilyTree> tree = new ArrayList<>();

    public FamilyTree(ArrayList<Human> persons) {
        this.persons = persons;
    }

    public FamilyTree() {

    }

    public ArrayList<NodeFamilyTree>getTree(){
        return tree;
    }

    public void AddManWoman(Human wife, Human husbent){
        tree.add(new NodeFamilyTree(wife, Family.wife, husbent));
        tree.add(new NodeFamilyTree(husbent, Family.husbent, wife));
    }

    public void ChildrenParent(Human children, Human parent){
        tree.add(new NodeFamilyTree(children, Family.children, parent));
        tree.add(new NodeFamilyTree(parent, Family.parent, children));
    }


}
