package view;

import presenter.Presenter;

import java.util.function.Predicate;

public interface View {

    void print(String text);
    void start();
}
