package Comands;
import java.io.IOException;

import Presenter.Presenter;

public class ComandPrintConsoleTree implements Option {
    Presenter presenter;

    @Override
    public String dicription() {
        String print = "Показать человеко в дереве";
        return print;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        presenter.comandPrintConsoleTree();

    }

}
