import model.*;
import presenter.Presenter;
import view.Console;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new Console();
        Service service = new Service(new PrintHumanList(), new FileHandler());
        new Presenter(view, service);

        service.fillTree(new BasicTreeGenerator());
        view.start();
    }


}
