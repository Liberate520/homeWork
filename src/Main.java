import model.Model;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;


public class Main {
    public static void main(String[] args) {
        // Инициализация модулей MVP
        Model model = new Model("notebook.txt");
        View view = new ConsoleUI();
        new Presenter(view, model);

        // Вызов метода старта программы
        view.start();
    }
}