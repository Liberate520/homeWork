package model.service;

import model.familyTree.FamilyTreeItem;
import model.human.Gender;
import model.human.Human;

public interface Service {
    void addTreeItem(String name, Gender gender, String birthDate,
                     Human father, Human mother);

    void addTreeItem(String name, Gender gender, String birthDate);

    FamilyTreeItem getById(long id);

    void remove(long id);

    String getHumanListInfo();
}
