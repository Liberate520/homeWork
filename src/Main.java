import model.Service;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);

        view.start();

    }
}