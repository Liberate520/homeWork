package ui.command;

import presenter.Presenter;
import ui.command.Command;


import java.util.Scanner;

public class ChangeNoteCommand extends Command {
    public static final String NAME = "Change a note";


    public ChangeNoteCommand (Presenter view, Scanner scanner) {
        super(NAME, view, scanner);
    }

    @Override
    public void execute() {
        presenter.showAllNotes();
        if (!presenter.isEmpty()) {
            System.out.println("Enter the number of note to change: ");
            final int num = scanner.nextInt();
            if (num < 0 || num > presenter.getNotepadSize()) {
                System.out.println("Note with such number does not exist.");
                System.out.println();
            } else {
                System.out.println("Enter new text: ");
                presenter.changeNoteByNumber(num);
            }
        }
    }
}

