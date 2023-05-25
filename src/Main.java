import model.Service;
import model.saving.LoadFromFile;
import model.saving.LoadableObject;
import model.saving.SavableObject;
import model.saving.SaveInFile;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        View view = new ConsoleUI();
        SavableObject saveInFile = new SaveInFile();
        LoadableObject loadFromFile = new LoadFromFile();
        Service service = new Service(saveInFile, loadFromFile);
        Presenter presenter = new Presenter(view, service);

        view.start();
    }
}
