package ui;

import model.human.Human;
import presenter.Presenter;

public interface View {
    void start();//метод открытие и создание графического окна или печать меню в консоли
    void setPresenter(Presenter presenter);
    void printHuman(Human human);//
    void printTree();
    void addHuman();
    void searchChild();
}
