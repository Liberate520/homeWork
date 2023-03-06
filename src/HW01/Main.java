package HW01;

import HW01.presenter.Presenter;
import HW01.ui.Console;
import HW01.ui.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new Console();
        new Presenter(view);
        view.start();
    }
}
