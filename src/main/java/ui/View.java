package ui;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    int selection();
    String scan(String message);
}
