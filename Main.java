package HW_6;

import HW_6.Services.Service;
import HW_6.pesenter.Presenter;
import HW_6.ui.Console;
import HW_6.ui.View;

public class Main {
    public static void main(String[] args) {

        View view = new Console();
        Service service = new Service();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}


