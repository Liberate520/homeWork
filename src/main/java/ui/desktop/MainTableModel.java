package ui.desktop;

import notes.Notes;
import notes.data.Note;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MainTableModel extends AbstractTableModel {
    private List<Note> listNotes;

    @Override
    public int getRowCount() {
        return listNotes.size();
    }

    public MainTableModel(List<Note> listNotes) {
        this.listNotes = listNotes;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Note note = listNotes.get(rowIndex);
        Object value = null;
        switch (columnIndex){
            case 0:
                value = note.getDate();
                fireTableCellUpdated(rowIndex, columnIndex);
                break;
            case 1:
                value = note.getNote();
                fireTableCellUpdated(rowIndex, columnIndex);
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "Дата";
                break;
            case 1:
                name = "Заметка";
                break;
        }
        return name;    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Note note = listNotes.get(rowIndex);
        switch (columnIndex){
            case 0:
                break;
            case 1:
                note.setNote((String)aValue);
                fireTableCellUpdated(rowIndex, columnIndex);
                break;
        }
    }
}
