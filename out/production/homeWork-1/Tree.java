/*
 * Decompiled with CFR 0.152.
 */
import java.util.ArrayList;
import java.util.List;

public class Tree
implements GenealogicalTree {
    private List<TreeElement> treeElementList;

    Tree(List<TreeElement> treeElementList) {
        this.treeElementList = treeElementList;
    }

    Tree() {
        this(new ArrayList<TreeElement>());
    }

    public List<TreeElement> getPersonList() {
        return this.treeElementList;
    }

    public void setPersonList(List<TreeElement> treeElementList) {
        this.treeElementList = treeElementList;
    }

    @Override
    public void addElement(TreeElement treeElement) {
        this.treeElementList.add(treeElement);
    }

    @Override
    public String toString() {
        return "personList = " + String.valueOf(this.treeElementList);
    }
}
