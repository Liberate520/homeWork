package Homeworks.OOPHW.OOP_homeWork_L5.src.View;

import Homeworks.OOPHW.OOP_homeWork_L5.src.Presenter.Presenter;

public interface Menu {
    public void printMenu();
    public void perform(int issue, Presenter presenter);
    int sizeMenu();
}
