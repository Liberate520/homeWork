import presenter.Presenter;
import tree.Service;
import ui.Console;
import ui.View;

public class Main {
    
    public static void main(String[] args) {
        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);
        view.start();
    }
    
}
