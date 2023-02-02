package VIVI.Print;

import Homework_6.Designer_Human;

import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class PrintList implements IPrintList {
    @Override
    public void printList(List<Designer_Human> humans) {
        showMessageDialog(null,humans);

    }

}
