package ui;

import notes.data.Note;
import presenter.Presenter;
import ui.desktop.AddNote;
import ui.desktop.EditNote;
import ui.desktop.MainTableModel;
import ui.desktop.MainWindow;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class DesktopUI implements View {
    private Presenter presenter;

    private JPanel panel;
    private String note;

    public void setNote(String note) {
        this.note = note;
    }

    public JTable getTable() {
        return table;
    }

    private JTable table;
//    private JFrame frame;

//В разработке

    public DesktopUI() {
        this.panel = new JPanel();
        panel.setName("Заметки");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
        System.out.println("Презентер установлен");
    }

    @Override
    public void selection() {
        MainWindow mainWindow = new MainWindow(this, presenter);
        this.table = mainWindow.getTable();

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
        AddNote addNote = new AddNote(this );
        presenter.addNote(new Note(note));
        presenter.saveNotes();
        table.repaint();
    }

    @Override
    public void removeNote() {
        System.out.println("Нажата кнопка удалить заметку");
        int row = table.getSelectedRow();
        presenter.removeNote(row+1);
        presenter.saveNotes();
    }

    @Override
    public void editNote() {
        System.out.println("Нажата кнопка редактировать");
        int column = 1;
        int row = table.getSelectedRow();
        if (row > -1) {
            String value = table.getModel().getValueAt(row, column).toString();
            System.out.println(value);
            EditNote editNote = new EditNote(this, table);
            String newNote = table.getModel().getValueAt(row, column).toString();
            presenter.saveNotes();
        }
    }
    @Override
    public void  replaceNote(int index, String value){
        presenter.replaceNote(index, value);
    }
    @Override
    public void saveNote(){
        presenter.saveNotes();
    }

    @Override
    public void print(String message) {

    }

    @Override
    public void exit() {
        System.out.println("Нажата кнопка выход");
    }


}
