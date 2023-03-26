package ui;

import presenter.Presenter;

public interface View {
    void setPresenter(Presenter presenter);
    void selection();
    String scan(String message);
    void showNotes();
    void addNote();
    void removeNote();
    void editNote();
    void print(String message);
    void exit();

    void replaceNote(int index, String value);
    void saveNote();
}
