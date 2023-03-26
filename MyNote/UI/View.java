package MyNote.UI;

import java.util.List;

import MyNote.Record;

public interface View {
    public String getText();
    public void setText(String volue);
    public int getIndex();
    public void printNoteBook(List<Record> list);
    public void showRecordAdded();
}
