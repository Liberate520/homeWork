import model.*;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.security.Provider;

public class Test {
    public static void main(String[] args) {
        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);

        view.start();
    }
}
