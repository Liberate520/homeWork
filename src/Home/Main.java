package Home;

import Home.model.human.Service;
import Home.presenter.Presenter;
import Home.ui.workWithData.Console;
import Home.ui.workWithData.View;

import java.io.*;

public class Main  {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new Console();
        Service service = new Service();
        new Presenter(view,service);
        view.start();

    }


}
