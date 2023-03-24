package ui;

import presenter.Presenter;
import ui.desktop.ButtonPanel;
import ui.desktop.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesctopUI implements View{
    private Presenter presenter;

    private JPanel panel;
    private JTable table;
    private JFrame frame;

//В разработке

    public DesctopUI() {
        panel = new JPanel();
        panel.setName("Заметки");

//        String[] columnNames = new String[]{"date","note"};
//        if (presenter != null) {
//            table = new JTable(presenter.getNotes().toArray(), columnNames);
//            table.setBounds(10, 10, 400, 400);
//            frame.add(new JScrollPane(table));
//            frame.setSize(600, 400);
//            frame.setVisible(true);
//            System.out.println("Здесь что то происходит");
//        }
//        else {
//            table = new JTable();
////            table = new JTable(presenter.getNotes().toArray(), columnNames);
//            table.setBounds(10, 10, 400, 400);
//            frame.add(new JScrollPane(table));
//            frame.setSize(600, 400);
//            frame.setVisible(true);
//            System.out.println("Здесь что то происходит");
//        }

    }

    //    super(new GridLayout(1,0));
//        String[] columnNames = new String[]{"date","note"};
//        Notes notes = presenter.getService().getNotes();
//        String[][] data = notes.toArray();
//        JTable table = new JTable(data, columnNames);
//        JScrollPane scrollPane = new JScrollPane(table);
//        add(scrollPane);
//        setPreferredSize(new Dimension(500,500));
//        setLayout(new FlowLayout());
//        setVisible(true);
//        setBackground(Color.WHITE);


    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
        System.out.println("Презентер установлен");
    }

    @Override
    public void selection() {
        MainWindow mainWindow = new MainWindow(this, presenter);
        this.table = mainWindow.getTable();
//        frame = new JFrame("Заметки");
//        frame.setSize(600,600);
//        String[] columnNames = new String[]{"Дата","Заметка"};
//        table = new JTable(presenter.getNotes().toArray(), columnNames);
////        table.setBounds(10, 10, 390, 100);
////        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        table.getColumnModel().getColumn(0).setPreferredWidth(100);
//        table.getColumnModel().getColumn(1).setPreferredWidth(600);
//        panel.add(new JScrollPane(table), BorderLayout.NORTH);
////        JButton b1 = new JButton("Редактировать заметку");
////        b1.setVerticalTextPosition(AbstractButton.CENTER);
////        b1.setHorizontalTextPosition(AbstractButton.CENTER);
////        b1.setSize(100,300);
////        b1.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                editNote();
////            }
////        });
////        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        ButtonPanel buttonPanel = new ButtonPanel(this);
//
//        JPanel buttonP = buttonPanel.getButtonPanel();
////        buttonPanel.add(b1,BorderLayout.SOUTH);
//        panel.add(buttonP);
//        panel.setVisible(true);
////        frame.setSize(500, 400);
//        frame.add(panel);
//        frame.setVisible(true);


    }

    @Override
    public String scan(String message) {
        return null;
    }

    @Override
    public void showNotes() {

    }

    @Override
    public void addNote() {
        System.out.println("Нажата кнопка добавить заметку");
    }

    @Override
    public void removeNote() {
        System.out.println("Нажата кнопка удалить заметку");
    }

    @Override
    public void editNote() {
        System.out.println("Нажата кнопка редактировать");
        int column = 1;
        int row = table.getSelectedRow();
        if (row > -1) {
            String value = table.getModel().getValueAt(row, column).toString();
            System.out.println(value);
            JFrame editFrame = new JFrame("Edit Note");
            editFrame.setSize(300,200);
            //todo some logic
            JPanel editPanel = new JPanel();
            JLabel editLabel = new JLabel("Введите измененный текст");
            editLabel.setVisible(true);
            editPanel.add(editLabel);
            editPanel.setVisible(true);
            editFrame.add(editPanel);
            editFrame.setVisible(true);
//            editFrame.setVisible(false);
        }
    }

    @Override
    public void print(String message) {

    }

    @Override
    public void exit() {
        System.out.println("Нажата кнопка выход");
    }


}
