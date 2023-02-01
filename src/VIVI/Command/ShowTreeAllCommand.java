package VIVI.Command;

import Homework_6.Designer_Human;
import VIVI.Print.IPrint;
import VIVI.Print.PrintTree;

import static javax.swing.JOptionPane.showMessageDialog;

public class ShowTreeAllCommand implements  ICommand{
    @Override
    public void execute() {
        Designer_Human designer_human = new Designer_Human();

        IPrint print = new PrintTree();
        print.printTree(); //Метод по умолчанию выводит на экран список designer_human

        showMessageDialog(null,"Все древо " + print);

    }

}
