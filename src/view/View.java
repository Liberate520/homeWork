package View;

import Model.GenealogicalTree.Animal;
import Presenter.Presenter;

public interface View<T extends Animal> {
    void setPresenter(Presenter<T> presenter);
    void start();
    void print(String text);
    String searchSetName();
    int addSetSex();
    int birthAddHuman();
}
