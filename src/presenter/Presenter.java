package presenter;

import notebook.Note;
import notebook.Notebook;
import ui.View;

import java.time.LocalDate;
import java.util.ArrayList;


public class Presenter {
    private final Notebook notebook;
    private final View view;


    public Presenter(Notebook notebook, View view) {
        this.notebook = notebook;
        this.view = view;
    }

    public void onClick() {
        while (true) {
            view.showMenu();

            int userChoice = view.userChoice();

            switch (userChoice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    if (!notebook.isEmpty()) view.printAll(notebook.toString());
                    else view.emptyNotebook();
                }
                case 2 -> {
                    ArrayList<String> userInput = view.addNote();
                    Note userNote = new Note(LocalDate.now(), userInput.get(0), userInput.get(1));
                    notebook.add(userNote);
                    view.addedNote();
                }
                case 3 -> {
                    if (notebook.isEmpty()) view.emptyNotebook();
                    else {
                        view.choiceRemove();
                        int numberNote = view.userChoiceRemove();
                        notebook.remove(numberNote);
                        view.removeNote();
                    }
                }
            }
        }
    }
}
