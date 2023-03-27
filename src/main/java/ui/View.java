package ui;

import presenter.Presenter;




public interface View {
    void setPresenter(Presenter presenter);
    void selection();
    void exit();
    void print(String message);
    void showNotes();
    void addNote();
    void removeNote();
    void editNote();
    void setNote(String note);
    void replaceNote(int index, String value);
    void saveNote();


}
