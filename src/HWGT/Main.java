package HWGT;
import HWGT.presenter.Presenter;
import HWGT.ui.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new Console();
        new Presenter(view);
        view.start();
    }
}