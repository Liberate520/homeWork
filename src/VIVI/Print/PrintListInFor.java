package VIVI.Print;

import Homework_6.Designer_Human;

import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class PrintListInFor implements IPrintList {
    @Override
    public void printList(List<Designer_Human> humans) {
        for (Designer_Human HHE : humans) {
            showMessageDialog(null, HHE);

        }

    }
}
