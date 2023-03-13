import presenter.Presenter;
import ui.Console;
import ui.View;

public class Main{    
    public static void main(String[] args) {
        View view = new Console();
        new Presenter(view);
        view.start();
    }
}