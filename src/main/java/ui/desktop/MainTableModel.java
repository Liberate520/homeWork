package ui.desktop;

import notes.data.Note;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MainTableModel extends AbstractTableModel {
    private List<Note> listNotes;

    public void refresh(){
        fireTableDataChanged();
    }

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
        switch (columnIndex) {
            case 0 -> {
                value = note.getDate();
                fireTableCellUpdated(rowIndex, columnIndex);
            }
            case 1 -> {
                value = note.getNote();
                fireTableCellUpdated(rowIndex, columnIndex);
            }
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Дата";
            case 1 -> "Заметка";
            default -> "??";
        };    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Note note = listNotes.get(rowIndex);
        switch (columnIndex) {
            case 0 -> fireTableCellUpdated(rowIndex, columnIndex);
            case 1 -> {
                note.setNote((String) aValue);
                fireTableCellUpdated(rowIndex, columnIndex);
            }
        }
    }


}
