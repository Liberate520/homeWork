package notepadapi;

import java.util.List;

public interface Service {
    List<Note> getRepo();
    void createNote(String note);

    void showAllNotes();

    void deleteNoteByNumber(int index);

    void changeNoteByNumber(int index);

    int getSize();
}
