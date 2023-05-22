
import presenter.Presenter;
import service.Service;
import ui.*;


public class Main {
    public static void main(String[] args) {
        View viewMainMenu = new ConsoleMainMenu();
        View viewWorkMenu = new ConsoleWorkMenu();
        Service service = new Service();
        new Presenter(viewMainMenu, service);
        new Presenter(viewWorkMenu,service);

        viewMainMenu.start();
    }
}
