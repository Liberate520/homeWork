import model.Model;
import model.ModelInterface;
import presenter.Presenter;
import ui.ConsoleUI;
import ui.View;

public class Main {
    public static void main(String[] args) {
        ModelInterface modelInterface = new Model();
        View view = new ConsoleUI();
        new Presenter(view, modelInterface);

        boolean flag = true;
        while (flag){
            flag = view.start();
        }
    }
}
