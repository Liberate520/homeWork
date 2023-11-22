import Model.Model;
import Presenter.Presenter;
import view.ConsoleUI;
import Model.FileWriteRead;
public class MainNew {
    public static void main(String[] args) {
        ConsoleUI view = new ConsoleUI();
        Presenter presenter = new Presenter(new ConsoleUI(), new Model(new FileWriteRead()));
        view.setPresenter(presenter);
        view.startMenu();
    }
}
