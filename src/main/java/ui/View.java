package ui;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void selection();
    String scan(String message);
}
