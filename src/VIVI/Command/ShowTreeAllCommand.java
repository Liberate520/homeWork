package VIVI.Command;

import Homework_6.Designer_Human;

import VIVI.Print.IPrintList;
import VIVI.Print.PrintListInFor;


import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;


public class ShowTreeAllCommand implements  ICommand{
    @Override
    public void execute() {
        Designer_Human designer_human = new Designer_Human();

        IPrintList print = new PrintListInFor();
        print.printList((List<Designer_Human>) designer_human); //Метод по умолчанию выводит на экран список designer_human

        showMessageDialog(null,"Все древо " + print);

    }

}
