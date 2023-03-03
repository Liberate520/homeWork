package org.example.gui;

import org.example.presenter.Presenter;

import java.io.IOException;

public interface View {
    void setPresenter(Presenter presenter);
    void start() throws IOException;
    void print(String string);

}
