package VIVI.Print;

import Homework_7.Designer_Human;

import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class PrintListAll implements IPrintList {
    Designer_Human designer_human;
    @Override
    public void printList(List<Designer_Human> humans) {
        for (Designer_Human human : designer_human.getHumans()) {
            showMessageDialog(null,human.toString());

        }
    }
}
