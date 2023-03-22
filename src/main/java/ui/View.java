package ui;

import notes.data.Notes;
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
}
