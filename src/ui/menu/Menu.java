package ui.menu;


import ui.View;


public interface Menu {

    View getView();

    void execute(int num);

    void showMenu();

    int getMenuListSize();
}
