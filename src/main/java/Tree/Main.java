package Tree;

import Tree.model.*;
import Tree.presenter.Presenter;
import Tree.ui.Console;
import Tree.ui.View;

public class Main {

    // метод для запуска приложения
    public static void main(String[] args) {
        View view = new Console();
        Service service = new FamilyTreeService();
        new Presenter(view, service);
        view.start();
    }
}