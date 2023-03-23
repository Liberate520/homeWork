package presenter;

import notebook.Note;
import notebook.Notebook;
import ui.View;

import java.time.LocalDate;
import java.util.ArrayList;


public class Presenter {
    private final Notebook notebook;


    public Presenter(View view, Notebook notebook) {
        this.notebook = notebook;
        view.setPresenter(this);

    }


    public boolean isFull() {
        return !notebook.isEmpty();
    }

    public void addNote(ArrayList<String> userInput) {
        Note userNote = new Note(LocalDate.now(), userInput.get(0), userInput.get(1));
        notebook.add(userNote);
    }

    public void changeNote(ArrayList<String> userInput, int index){
        Note newNote = new Note(LocalDate.now(), userInput.get(0), userInput.get(1));
        notebook.change(index, newNote);
    }


    public void removeNote(int number) {
        notebook.remove(number - 1);
    }

    public String printAll() {
        return notebook.toString();
    }

    public int getSizeNotebook() {
        return notebook.getSize();
    }

}
