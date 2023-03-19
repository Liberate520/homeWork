import model.Notebook;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;


public class Main {
    public static void main(String[] args) {

        Notebook notebook = new Notebook("data.txt");
        View view = new ConsoleUI();
        new Presenter(view, notebook);
        view.start();
    }
}