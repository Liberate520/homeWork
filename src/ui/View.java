package ui;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void print(String text);
    void start() throws IOException;
    void setPresenter(Presenter presenter);

    void addHuman();
    void getInfo();
    void finish();

    void save();
    void load();

    void sortByLastName();

    void sortByFirstName();
}
