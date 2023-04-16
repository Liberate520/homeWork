import presenter.Presenter;
import ui.Console;
import ui.Iview;

public class program {
    public static void main(String[] args) {
        Iview view = new Console();
        new Presenter(view);
        view.start();

        

    }
}
