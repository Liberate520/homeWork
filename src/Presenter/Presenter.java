package Homework25_2.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import Homework25_2.Model.Note;
import Homework25_2.Model.Notebook;
import Homework25_2.UI.View;


public class Presenter {
    private final Notebook notebook;
    private final View view;


    public Presenter(Notebook notebook, View view) {
        this.notebook = notebook;
        this.view = view;
    }


    public void showAllNote(){
        if (!notebook.isEmpty()) view.printAll(notebook.toString());
                    else view.emptyNotebook();
    }

    public void deleteNOte(){

    }
    public void onClick() {
        while (true) {

            int userChoice = view.printMenu();

            switch (userChoice) {
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
                        int numberNote = view.choiceRemove(notebook.getSize());
                        notebook.remove(numberNote);
                        view.removedNote();
                    }
                }
                case 4 -> {
                    return;
                }
            }
        }
    }
}