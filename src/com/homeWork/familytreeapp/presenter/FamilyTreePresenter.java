package com.homeWork.familytreeapp.presenter;

import java.util.List;

import com.homeWork.familytreeapp.model.GenealogicalTree;
import com.homeWork.familytreeapp.model.Person;
import com.homeWork.familytreeapp.view.UserInterface;

public class FamilyTreePresenter<T extends Person<T>> {
    private final GenealogicalTree<T> familyTree;
    private final UserInterface<T> userInterface;

    public FamilyTreePresenter(GenealogicalTree<T> familyTree, UserInterface<T> userInterface) {
        this.familyTree = familyTree;
        this.userInterface = userInterface;
        userInterface.setPresenter(this);
    }

    public void addParent(T parent, T child) {
        familyTree.addParent(parent, child);
    }

    public void addSibling(T sibling1, T sibling2) {
        familyTree.addSibling(sibling1, sibling2);
    }

    public List<T> getChildren(T parent) {
        return familyTree.getChildren(parent);
    }
}

