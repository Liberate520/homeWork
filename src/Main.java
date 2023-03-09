import familyApi.Service;
import presenter.Presenter;
import ui.ConsoleUi;

public class Main {
    public static void main(String[] args) {
        ConsoleUi viev = new ConsoleUi();
        new Presenter(viev, new Service());
        viev.start();
    }
}
