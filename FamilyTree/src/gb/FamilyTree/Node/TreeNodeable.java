package gb.FamilyTree.Node;

import java.util.ArrayList;

public interface TreeNodeable<E> {
    public int getId();

    public ArrayList<E> getParents();

    public ArrayList<E> getOneLevelNodes();

    public ArrayList<E> getChilds();

    public void setParents(ArrayList<E> parents);

    public void setChilds(ArrayList<E> childs);

    public void addParentCommunication(E parent);

    public void addOneLevelCommunication(E parent);

    public void addChildNode(E child);

    public String getFirstName();
}