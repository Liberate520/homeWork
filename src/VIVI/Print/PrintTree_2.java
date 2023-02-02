package VIVI.Print;

import Homework_6.Designer_Human;

import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class PrintTree_2 implements IPrint {
    @Override
    public void printTree() {
        List<Designer_Human> humans;
        humans = (List<Designer_Human>) new Designer_Human();
        for (Designer_Human HHE : humans) {
            showMessageDialog(null, HHE);

        }

    }

}


