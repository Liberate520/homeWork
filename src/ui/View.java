package ui;

import model.HumanComparatorByName;
import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);

}
