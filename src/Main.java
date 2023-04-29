import model.Service;
import model.famalyTree.FamilyTree;
import model.humans.*;
import presenter.Presenter;
import ui.Console;
import ui.View;

public class Main {
    public static void main(String[] args){
        Service service = new Service();
        View view = new Console();
        Presenter presenter = new Presenter(view, service);
        view.start();
    }
}