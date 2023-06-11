package view;

import model.Human;
import presenter.Presenter;

import java.io.IOException;
import java.util.List;

public interface View {
    void print(String text);
    void start() throws IOException, ClassNotFoundException;
    void setPresenter(Presenter presenter);


    void ShowList();
    void addHuman();
    void sortByName();
    void sortByBirthDate();
    void findByName();
    void findBrothers();
    void saveToFile() throws IOException;
    void loadFromFile() throws IOException, ClassNotFoundException;
    void finish();
}
