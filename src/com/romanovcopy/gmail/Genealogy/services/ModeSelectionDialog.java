package com.romanovcopy.gmail.Genealogy.services;

import javax.swing.JOptionPane;

public class ModeSelectionDialog {
    public String[]options;
    public ModeSelectionDialog(String[]options){
        this.options=options;
    }
    public int select() {
        // Отображение всплывающего окна и получение выбранного режима
        int choice = JOptionPane.showOptionDialog(null, "Выберите режим работы:", "Выбор режима",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return choice;
    }
}


