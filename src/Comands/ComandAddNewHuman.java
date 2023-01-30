package Comands;

import java.io.IOException;

import Presenter.Presenter;

public class ComandAddNewHuman implements Option {
    private Presenter presenter;

    @Override
    public String dicription() {
        String newHuman = "Добавить человека в дерево";
        return newHuman;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandAddNewHuman();
    }

}
