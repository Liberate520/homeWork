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


        service.addHuman("Иван", "Петров", 45);
        service.addHuman("Мария", "Петрова", 35);
        service.addHuman("Татьяна", "Петрова",17);
        service.addHuman("Екатерина", "Петрова", 15);
        service.addHuman("Егор", "Петров", 13);
        view.start();

    }
}