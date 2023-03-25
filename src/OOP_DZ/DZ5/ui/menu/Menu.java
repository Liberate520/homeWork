package OOP_DZ.DZ5.ui.menu;


import OOP_DZ.DZ5.ui.View;


public interface Menu {

    View getView();

    void execute(int num);

    void showMenu();

    int getMenuListSize();
}
