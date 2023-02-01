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

        outer:
        for (; ; ) {
            String txt = showInputDialog("""
                    \t\t\t\t\t\tДобро пожаловать в программу \n
                    \t\t\t\t\t\tгенеалогическова древа\n
                    \t\t\t\t\t\t\t\t\tВыберете действие
                    
                    \t\t\t\t\t\t\t\t\tДобавить человека
                    \t\t\t\t\t\t\t\t\tДобавить детей
                    \t\t\t\t\t\t\t\t\tДобавить родителей
                    \t\t\t\t\t\t\t\t\tПоказать все древо
                    \t\t\t\t\t\t\t\t\tПоиск по имени
                    \t\t\t\t\t\t\t\t\tСортировка""");
            switch (txt.toLowerCase()) {
                case "добавить человека" -> presenter.AddHumanCommandRecord();
                case "добавить детей" -> presenter.AddСhildrenCommandRecord();
                case "добавить родителей" -> presenter.AddParentsCommandRecord();
                case "показать все древо" -> presenter.ShowTreeAllCommandRecord();
                case "поиск по имени" -> presenter.SearchCommandRecord();
                case "сортировка" -> presenter.SortingCommand();
                default -> {
                    showMessageDialog(null, "Промазал давай по новой ");
                    continue outer;
                }
            }
                String txt2 = showInputDialog(null, "\t\t\t\t\t\t\t\t\tПовторить Выбор ?\n\t\t\t\t\t\t\t\t\tДа? \t\t\t\t\t\t\t\t\tНет?");

            if (Objects.equals(txt2.toLowerCase(), "да")) {
                    continue outer;
                } else {
                    Objects.equals(txt2.toLowerCase(), "нет");{
                        break outer; //я не знаю почему светит серым, но все работает
                    }
                }


            }


        }
    }

/*
через условный оператор как то работало чрез жопу, через switch
 */
