import model.Notes;
import presenter.Presenter;
import view.*;

public class Main {
    public static void main(String[] args) {
        View view = new Menu();
        Notes notebook = new Notes();
        Presenter presenter = new Presenter(view, notebook);

        view.start();
    }
    
}