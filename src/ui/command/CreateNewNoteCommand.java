package ui.command;

import presenter.Presenter;

import java.util.Scanner;

public class CreateNewNoteCommand extends Command {
    public static final String NAME = "Create a note";


    public CreateNewNoteCommand(Presenter view, Scanner scanner) {
        super(NAME, view, scanner);
    }

    @Override
    public void execute() {
        System.out.println("Print text of new note: ");
        scanner.nextLine();
        final String text = scanner.nextLine();
        presenter.createNewNote(text);
    }
}

