package ui.desktop;

import presenter.Presenter;
import ui.View;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    Presenter presenter;
    JFrame frame;
    JPanel panel;

    public JTable getTable() {
        return table;
    }

    JTable table;
    View view;

    public MainWindow(View view, Presenter presenter) {
        this.presenter = presenter;
        this.view = view;
        this.frame = new JFrame("Заметки");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        String[] columnNames = new String[]{"Дата","Заметка"};
//        this.table = new JTable(presenter.getNotes().toArray(), columnNames);
        this.table = new JTable(new MainTableModel(presenter.getNotes().getNotes()));
//        table.setBounds(10, 10, 390, 100);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(600);
        this.panel = new JPanel();
        panel.add(new JScrollPane(table), BorderLayout.NORTH);
//        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel buttonPanel = new ButtonPanel(view);

        JPanel buttonP = buttonPanel.getButtonPanel();
//        buttonPanel.add(b1,BorderLayout.SOUTH);
        panel.add(buttonP);
        panel.setVisible(true);
//        frame.setSize(500, 400);
        frame.add(panel);
        frame.setVisible(true);
}
}
