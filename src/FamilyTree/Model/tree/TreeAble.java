package FamilyTree.Model.tree;

import FamilyTree.Model.sort.NameComparator;
import FamilyTree.Model.sort.PersonIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public interface TreeAble  <E extends Being> {


    public boolean addPerson(E person);

    public void addToParents(E person);

    public void addToChild(E person);

    public String getInfo();

    public E getById(Integer id);



    public void sortName();
    public void sortAge();
}

