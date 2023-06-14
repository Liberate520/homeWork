package view;

import presenter.Presenter;

import java.io.IOException;

public interface View {
    void start() throws IOException, ClassNotFoundException;
    void setPresenter(Presenter presenter);
    void ShowList();
    void addHuman();
    void findByName();
    void saveToFile() throws IOException;
    void loadFromFile() throws IOException, ClassNotFoundException;
    void finish();
}
