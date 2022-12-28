import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
public class Tree implements GenealogicalTree {
    private List<TreeElement> treeElementList;
    
    Tree(List<TreeElement> treeElementList) {
        this.treeElementList = treeElementList;
    }

    Tree() {
        this(new ArrayList<>());
    }
    
    public List<TreeElement> getPersonList() {
        return treeElementList;
    }

    public void setPersonList(List<TreeElement> treeElementList) {
        this.treeElementList = treeElementList;
    }
    
    public void addElement(TreeElement treeElement) {
        treeElementList.add(treeElement);
    }

    @Override
    public TreeElement findElement(String name) {
        for (TreeElement treeElement : treeElementList) {
            if (treeElement.getName().equals(name)) {
                return treeElement;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "personList = " + treeElementList;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;
    }
}