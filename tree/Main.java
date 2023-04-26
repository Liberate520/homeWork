
import ui.View;

import ui.Console;
import model.ServiceFamilyTree;
import presenter.Presenter;

public class Main {
    public static void main(String[] args) {
        ServiceFamilyTree serviceFamilyTree = new ServiceFamilyTree();
        View view = new Console();
        Presenter presenter = new Presenter(view, serviceFamilyTree);
        view.setPresenter(presenter);
        view.start();

    }
}
