import model.Model;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;


public class Main {
    public static void main(String[] args) {

        Model model = new Model("data.txt");
        View view = new ConsoleUI();
        new Presenter(view, model);
        view.start();
    }
}