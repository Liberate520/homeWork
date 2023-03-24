import java.io.IOException;

import mvp.Model;
import mvp.Presenter;
import mvp.View;
import storage.FileStorage;
import storage.Storage;
import ui.ConsoleView;

public class Main {
    public static void main(String[] args) throws IOException {
        Storage storage = new FileStorage();
        Model model = new Model(storage);
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view, model);
        presenter.start();
    }
}
