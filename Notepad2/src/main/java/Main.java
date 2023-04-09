import model.Model;
import model.ModelInterface;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.DesktopUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        ModelInterface modelInterface = new Model();
//        View view = new DesktopUI();
        View view = new ConsoleUI();
        new Presenter(view, modelInterface);

        view.start();
    }
}
