package MyNote.UI;


import MyNote.Notebook;

public interface View {
    public String getText();
    public void printText(String value);
    public int getIndex();
    public void printNoteBook(Notebook list);
    public void showRecordAdded();
    public void showNoRecords();
    public void noRecods();
}