import presenter.Presenter;
import view.Console;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new Console();
        new Presenter(view);
        view.start();
    }
}