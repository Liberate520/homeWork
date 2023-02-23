import familyApi.Service;
import presenter.Presenter;
import ui.ConsoleUi;

public class Main {
    public static void main(String[] args) {
        Presenter presenter = new Presenter(new ConsoleUi(), new Service());
        presenter.start();
    }
}
