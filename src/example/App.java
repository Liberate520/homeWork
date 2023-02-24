package org.example;

import org.example.comparator.ComparatorFunction;
import org.example.comparator.ComparatorHuman;
import org.example.file.TreeHandlerTxt;
import org.example.gui.ConsoleUi;
import java.io.IOException;


public class App
{
    public static void main( String[] args ) throws IOException {
        Tree <Human>treeFamDem = new TreeHandlerTxt().read("File.txt"); // Загрузка с файла +++++++++++++++++++
        ComparatorHuman.sortTree(treeFamDem.getBigFamily(), ComparatorFunction.dateOfBirth);

        ConsoleUi consoleUi = new ConsoleUi(treeFamDem);
        consoleUi.start();

        ComparatorHuman.sortTree(treeFamDem.getBigFamily(), ComparatorFunction.id);    // перед записью сортировка по id
        new TreeHandlerTxt().write(treeFamDem);  // сохранение

    }
}
