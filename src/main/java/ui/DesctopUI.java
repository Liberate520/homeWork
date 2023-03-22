package ui;

import notes.Service;
import notes.data.Notes;
import presenter.Presenter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class DesctopUI implements View{
    private Presenter presenter;

    private JFrame frame;
    private JTable table;

    public DesctopUI() {
//        frame = new JFrame();
//        frame.setTitle("Notes");
//        String[] columnNames = new String[]{"date","note"};
//        if (presenter != null) {
//            table = new JTable(presenter.getService().getNotes().toArray(), columnNames);
//            table.setBounds(10, 10, 400, 400);
//            frame.add(new JScrollPane(table));
//            frame.setSize(400, 400);
//            frame.setVisible(true);
//        }
//        else {
//            table = new JTable();
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
//        setPreferredSize(new Dimension(500,500)

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
        System.out.println("Презентер установлен");
    }

    @Override
    public void selection() {

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

    }

    @Override
    public void removeNote() {

    }

    @Override
    public void editNote() {

    }

    @Override
    public void print(String message) {

    }

    @Override
    public void exit() {

    }


}
