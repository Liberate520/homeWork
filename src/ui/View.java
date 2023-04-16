package ui;

import model.People.Gender;
import model.People.Person;
import presenter.Presenter;

import java.util.ArrayList;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
}
