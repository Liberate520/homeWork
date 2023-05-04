package familyTree;

import familyTree.model.ServiceHuman;
import familyTree.presenter.Presenter;
import familyTree.ui.UiConsole;
import familyTree.ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new UiConsole();
        ServiceHuman service = new ServiceHuman("Петровы");
        new Presenter(view, service);
        view.start();
    }
}
