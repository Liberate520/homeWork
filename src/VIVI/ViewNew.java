package VIVI;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import VIVI.Command.*;

import javax.swing.*;
import java.util.Objects;

public class ViewNew {
    public void ViewvNEW() {
        //Новый метод вызова
        Presenter presenter = new Presenter(
                new AddHumanCommand(),
                new AddCildrenCommand(),
                new AddParentsCommand(),
                new SearchCommand(),
                new ShowTreeAllCommand(),
                new SortingCommand()

        );

        outer:
        for (; ; ) {
            String txt = showInputDialog("""
                    Добро пожаловать в программу генеалогическова древа\n" +
                    "Выберете действие\n\n\n" 
                    "Добавить пользователя" 
                    "Добавить детей" 
                    "Добавить родителей" 
                    "Показать все древо" 
                    "Поиск по имени" 
                    "Сортировка""");
            if (Objects.equals(txt, "Добавить пользователя")) {
                presenter.AddHumanCommandRecord();
            } else if (Objects.equals(txt, "Добавить детей")) {
                presenter.AddСhildrenCommandRecord();
            } else if (Objects.equals(txt, "Добавить родителей")) {
                presenter.AddParentsCommandRecord();
            } else if (Objects.equals(txt, "Показать все древо")) {
                presenter.ShowTreeAllCommandRecord();
            } else if (Objects.equals(txt, "Поиск по имени")) {
                presenter.SearchCommandRecord();
            } else if (Objects.equals(txt, "Сортировка")) {
                presenter.SortingCommand();
            } else {
                String txt2 = showInputDialog(null, "Повторить Выбор ?\nДа? Нет?");
                if (Objects.equals(txt2, "Да")) {
                    continue outer;
                } else {
                    Objects.equals(txt2, "Нет");{
                        break outer; //я не знаю почему светит серым, но все работает
                    }
                }


            }


        }
    }
}
/*
выбор между исключением ошибки и циклом я выбрал цикл )))
Можно было использовать и while, но пришлось бы много прописывать break
 */
