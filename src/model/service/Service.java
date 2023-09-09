package model.service;

import model.familyTree.FamilyTreeItem;

public interface Service {
    void addTreeItem(FamilyTreeItem item);
    FamilyTreeItem getById(long id);
    void remove(long id);
    String getHumanListInfo();
}
