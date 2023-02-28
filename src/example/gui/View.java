package org.example.gui;

import org.example.presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void start();

}
