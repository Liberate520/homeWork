package program;

import java.io.IOException;

import view.*;
import model.tree.classes.Service;
import presenter.Presenter;


public class Program {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Console view = new Console();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}
