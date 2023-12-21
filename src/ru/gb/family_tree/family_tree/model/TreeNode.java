package ru.gb.family_tree.family_tree.model;

import ru.gb.family_tree.family_tree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode <A> extends Serializable,Comparable<A> {
    public int getAge();
    A getMother();
    A getFather();
    public void setMother(A mother);
    public void setFather(A father);
public boolean addChild(A human);
public boolean addParent(A human);
String getName();
LocalDate getDeathDate();
LocalDate getBirthDate();
List<A>getParents();
List<A>getChildrens();
public int getID();
public String getListChildrens();
public String getListParents();
public void setID(int num);
}
