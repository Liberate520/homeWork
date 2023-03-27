package ui;

import notes.data.Note;
import presenter.Presenter;
import ui.desktop.AddNote;
import ui.desktop.EditNote;
import ui.desktop.MainTableModel;
import ui.desktop.MainWindow;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class DesktopUI implements View {
    private Presenter presenter;

    private JFrame frame;
    private JTable table;

@Override
    public void setNote(String note) {
        presenter.addNote(new Note(note));
        showNotes();
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void selection() {
        MainWindow mainWindow = new MainWindow(this, presenter);
        this.frame = mainWindow.getframe();
        this.table = mainWindow.getTable();
    }

    @Override
    public void exit() {
        saveNote();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
    }


    @Override
    public void print(String message) {
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), message);
    }


    @Override
    public void showNotes() {
        ((MainTableModel) table.getModel()).refresh();
    }

    @Override
    public void addNote() {
        System.out.println("Нажата кнопка добавить заметку");
        AddNote addNote = new AddNote(this );
    }

    @Override
    public void removeNote() {
        System.out.println("Нажата кнопка удалить заметку");
        int row = table.getSelectedRow();
        presenter.removeNote(row+1);
        print("Заметка удалена");
        showNotes();
    }

    @Override
    public void editNote() {
        System.out.println("Нажата кнопка редактировать");
        int column = 1;
        int row = table.getSelectedRow();
        if (row > -1) {
            EditNote editNote = new EditNote(this, table);
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

}
