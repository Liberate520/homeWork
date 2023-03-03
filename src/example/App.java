package org.example;

import org.example.model.communication.Service;
import org.example.model.communication.SystemModelCommunication;


import org.example.gui.ConsoleUI;
import org.example.gui.View;
import org.example.presenter.Presenter;


import java.io.IOException;


public class App
{
    public static void main( String[] args ) throws IOException {
        //  new ComparatorHuman().sortTree(tree.getBigFamily(), ComparatorFunction.dateOfBirth);
        // сортировка через меню в стадии разработки

        View view = new ConsoleUI();
        Service sc = new SystemModelCommunication();
        new Presenter(view, sc);
        view.start();


        //new ComparatorHuman().sortTree(tree.getBigFamily(), ComparatorFunction.id); // перед записью сортировка по id
        //new TreeHandlerTXT().write(tree);  // сохранение
    }
}
