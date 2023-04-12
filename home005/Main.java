
import model.Notes;
import presenter.Presenter;
import view.*;

public class Main {
    public static void main(String[] args) {
        Notes notebook = new Notes();
        
        View view = new Console();
        new Presenter(view, notebook);
        view.start();       
    }
}