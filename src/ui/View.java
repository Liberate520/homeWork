package ui;

import presenter.Presenter;

import java.util.ArrayList;

public interface View {
    void setPresenter(Presenter presenter);
    void onClick();

}
