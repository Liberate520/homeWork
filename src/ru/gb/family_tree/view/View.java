package ru.gb.family_tree.view;

import ru.gb.family_tree.view.menus.Menu;

public interface View {

    Menu previousMenu();
    void start();
    void print(String data);

}
