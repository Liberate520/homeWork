package model.creature.Interface;

import model.creature.Creature;

import java.util.List;

public interface AddChildren<T> {
    boolean addChildren(T child);
    List<T> getChildren();
    void setChildren(List<T> children);
    String getChildrenInfo();
}
