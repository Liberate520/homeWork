package VIVI;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import VIVI.Command.*;

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

        showMessageDialog(null, """ 
                Добро пожаловать в программу генеалогическова древа
                              Выберете действие
                                
                                1.Добавить пользователя
                                2.Добавить детей
                                3.Добавить родителей
                                4.Показать все древо
                                5.Поиск по имени
                                6.Сортировка
                """);
        String txt = showInputDialog("Напишите действие");
        if (Objects.equals(txt, "Добавить пользователя")) {
            presenter.AddHumanCommandRecord();
        } else if (Objects.equals(txt, "Добавить детей")) {
            presenter.AddСhildrenCommandRecord();
        } else if (Objects.equals(txt, "Добавить родителей")) {
            presenter.AddParentsCommandRecord();
        }else if (Objects.equals(txt, "Показать все древо")) {
            presenter.ShowTreeAllCommandRecord();
        }else if (Objects.equals(txt, "Поиск по имени")) {
            presenter.SearchCommandRecord();
        }else if (Objects.equals(txt, "Сортировка")) {
            presenter.SortingCommand();
        }
    }


}
