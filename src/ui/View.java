package ui;

import model.human.Human;
import presenter.Presenter;

public interface View {
    void start();//метод открытие и создание графического окна
    void setPresenter(Presenter presenter);
    void printHuman(Human human);//
    void printTree();
 //   void printHuman();
}
