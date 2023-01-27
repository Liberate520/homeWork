package VIVI;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

import VIVI.Command.*;

import javax.swing.*;
import java.util.Objects;

public class ViewNew {
    public void ViewvNEW(){
        //Новый метод вызова
        Developer developer =new Developer(
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
                                2.Добавить пользователя с Id
                                3.Добавить детей
                                4.Добавить родителей
                                5.Показать все древо
                                6.Поиск по имени
                                7.Сортировка
                """);
        String txt = showInputDialog("Напишите действие");
        if (Objects.equals(txt, "Добавить пользователя")){
            developer.AddHumanCommandRecord();
        } else if (Objects.equals(txt, "Добавить пользователя с Id"))


        developer.AddHumanCommandRecord();
        developer.AddСhildrenCommandRecord();
        developer.AddParentsCommandRecord();
        developer.SearchCommandRecord();
        developer.ShowTreeAllCommandRecord();
        developer.SortingCommand();
    }


}
