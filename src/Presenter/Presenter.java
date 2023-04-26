package Presenter;

import Human.Human;
import Services.Service;
import Tree.Tree;
import ui.ConsoleUi;
import ui.View;

import java.io.IOException;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public void menuInput(int menuOption) throws IOException, ClassNotFoundException {
    switch (menuOption){
        case 1:
            service.printTree();
            break;
        case 2:
            service.saveTree();
            break;
        case 3:
            service.loadTree();
            break;
        case 4:
            service.sortBySecondName();
            break;
        case 5:
            service.sortBySex();
            break;
        case 6:
            service.sortByYear();
            break;
        }
    }
}
