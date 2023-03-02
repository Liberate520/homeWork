package model;

import presenter.Presenter;
import ui.ConsoleOne;
import ui.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleOne();
        Model model = new Servis();
        new Presenter(view, model);
        view.start();
    }
}
