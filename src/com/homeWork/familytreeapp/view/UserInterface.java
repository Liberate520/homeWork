package com.homeWork.familytreeapp.view;

import com.homeWork.familytreeapp.model.Person;
import com.homeWork.familytreeapp.presenter.FamilyTreePresenter;

public interface UserInterface<T extends Person<T>> {
    void setPresenter(FamilyTreePresenter<T> presenter);
    void run();
}
