package ru.gb.family_tree.presenter;


import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.ui.ConsoleUI;
import ru.gb.family_tree.ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
}
