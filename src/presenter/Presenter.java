package presenter;

import notepadapi.Service;
import notepadapi.ServiceImpl;

public class Presenter {

    private final Service service = new ServiceImpl();

    public Presenter() {
    }

    public int getNotepadSize(){
        return service.getSize();
    }
    public void createNewNote(String note) {
        service.createNote(note);
    }

    public void showAllNotes() {
        service.showAllNotes();
    }

    public void deleteNoteByNumber(int number) {
        service.deleteNoteByNumber(number);
    }


    public void changeNoteByNumber(int index)  {
        service.changeNoteByNumber(index);
    }

    public boolean isEmpty(){
        if (!service.getRepo().isEmpty()) {
            return false;
        }
        return service.getRepo().isEmpty();
    }
}
