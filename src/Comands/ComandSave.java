package Comands;

import java.io.IOException;

import Presenter.Presenter;

public class ComandSave implements Option {
    Presenter presenter;

    public ComandSave() {
    }

    @Override
    public String dicription() {
        String save = "Сохранить ваше дерево";
        return save;
    }

    @Override
    public void execute() throws IOException {
        presenter.comandSave();
    }

}
