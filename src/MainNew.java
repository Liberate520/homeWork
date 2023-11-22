import Presenter.Presenter;
import view.ConsoleUI;

public class MainNew {
    public static void main(String[] args) {
        ConsoleUI view = new ConsoleUI();
        Presenter presenter = new Presenter(view);
        view.setPresenter(presenter);
        view.startMenu();
    }
}
