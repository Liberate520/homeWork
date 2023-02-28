package org.example;

import org.example.gui.View;
import org.example.model.Human;
import org.example.model.Tree;
import org.example.model.communication.SystemModelCommunication;
import org.example.gui.ConsoleUi;
import org.example.model.comparator.ComparatorFunction;
import org.example.model.comparator.ComparatorHuman;
import org.example.model.file.TreeHandlerTxt;
import org.example.presenter.Presenter;

import java.io.IOException;


public class App
{
    public static void main( String[] args ) throws IOException {
        Tree<Human> treeFamDem = new TreeHandlerTxt().read("File.txt"); // Загрузка с файла +++++++++++++++++++
        new ComparatorHuman().sortTree(treeFamDem.getBigFamily(), ComparatorFunction.dateOfBirth);

        View view = new ConsoleUi();
        SystemModelCommunication sc = new SystemModelCommunication(treeFamDem);
        new Presenter(view, sc);
        view.start();

        new ComparatorHuman().sortTree(treeFamDem.getBigFamily(), ComparatorFunction.id);    // перед записью сортировка по id
        new TreeHandlerTxt().write(treeFamDem);  // сохранение
    }
}
