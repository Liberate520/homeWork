package family_tree.view.consoleUI;

import family_tree.presenter.Presenter;
import family_tree.view.View;
import family_tree.view.consoleUI.menu.Menu;

public class ConsoleUi implements View {

    private Presenter presenter;
    private Menu menu;
    private boolean working;

    public ConsoleUi() {
        presenter = new Presenter(this);
        menu = new Menu(this);
        working = true;
    }
    @Override
    public void start() {
        while (working) {
            menu.openMainMenu();
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void createTreeOfPerson(){
        presenter.createTreeOfPerson();
    }

    public void createTreeOfDog(){
        presenter.createTreeOfDog();
    }

    public void finish() {
        working = false;
    }

    public Menu getMenu() {
        return menu;
    }
}
