package ru.gb.family_tree.family_tree.presenter;

import ru.gb.family_tree.family_tree.model.Service.Service;
import ru.gb.family_tree.family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
}
