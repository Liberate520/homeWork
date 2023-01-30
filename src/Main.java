import model.*;
import presenter.Presenter;
import view.MyView;

public class Main {
    public static void main(String[] args) {
        MyView myView = new MyView();
        Repository repository = new TreeRepository();
        Presenter presenter = new Presenter(repository, myView);

        myView.start();

    }
}
