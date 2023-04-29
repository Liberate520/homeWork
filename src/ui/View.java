package ui;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void finish();
    void setPresenter(Presenter presenter);
    void start() throws IOException, ClassNotFoundException;
    void print(String text);
    void addMember();
    void getFamily();
    void save() throws IOException;

    void load() throws IOException, ClassNotFoundException;

    void getRelatives();
}
