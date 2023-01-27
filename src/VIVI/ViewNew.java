package VIVI;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import VIVI.Command.*;

import javax.swing.*;
import java.util.Objects;

public class ViewNew {
    public void ViewvNEW() {
        //Новый метод вызова
        Developer developer = new Developer(
                new AddHumanCommand(),
                new AddCildrenCommand(),
                new addParentsCommand(),
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
            developer.AddHumanCommandRecord();
        } else if (Objects.equals(txt, "Добавить детей")) {
            developer.AddСhildrenCommandRecord();
        } else if (Objects.equals(txt, "Добавить родителей")) {
            developer.AddParentsCommandRecord();
        }else if (Objects.equals(txt, "Показать все древо")) {
            developer.ShowTreeAllCommandRecord();
        }else if (Objects.equals(txt, "Поиск по имени")) {
            developer.SearchCommandRecord();
        }else if (Objects.equals(txt, "Сортировка")) {
            developer.SortingCommand();
        }
    }


}
