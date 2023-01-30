package Comands;

import java.io.IOException;

import Presenter.Presenter;

public class ComandSearchByName implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String search = "Поиск человека по имени";
        return search;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandSearchByName();

    }

}
