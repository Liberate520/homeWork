package view;

import model.Animal;
import presenter.Presenter;

public interface View<T extends Animal> {
    void setPresenter(Presenter<T> presenter);
    void start();
    void print(String text);
    String searchSetName();
}
