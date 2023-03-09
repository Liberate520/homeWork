package View;

import Presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();
    void print(String text);
    String searchSetName();
    int addSetSex();
    int birthAddHuman();
}
