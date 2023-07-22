package FamTree;

import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<NodeFamilyTree> tree = new ArrayList<>();

    public ArrayList<NodeFamilyTree>getTree(){
        return tree;
    }

    public void ManWoman(Human vife, Human husbent){
        tree.add(new NodeFamilyTree(vife, Family.vife, husbent));
        tree.add(new NodeFamilyTree(husbent, Family.husbent, vife));
    }

    public void ChildrenParent(Human children, Human parent){
        tree.add(new NodeFamilyTree(children, Family.children, parent));
        tree.add(new NodeFamilyTree(parent, Family.parent, children));
    }
}
