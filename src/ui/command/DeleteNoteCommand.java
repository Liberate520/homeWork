package ui.command;

import presenter.Presenter;

import java.util.Scanner;

public class DeleteNoteCommand extends Command {
    public static final String NAME = "Detele a note";


    public DeleteNoteCommand(Presenter presenter, Scanner scanner) {
        super(NAME, presenter, scanner);
    }

    @Override
    public void execute() {
        presenter.showAllNotes();
        if (!presenter.isEmpty()) {
            System.out.println("Enter the number of note to delete: ");
            try {
                final int num = scanner.nextInt();
                presenter.deleteNoteByNumber(num);
            } catch (Exception e) {
                System.out.println("Note with such number does not exist.");
                System.out.println();
            }
        }
    }
}
