import java.io.IOException;

import presenter.Presenter;
import UI.Console;
import UI.interfaces.View;


public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new Console();
        new Presenter(view);
        view.start();
    }
}