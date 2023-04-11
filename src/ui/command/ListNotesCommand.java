package ui.command;

import presenter.Presenter;

import java.util.Scanner;

public class ListNotesCommand extends Command {

    public static final String NAME = "Show all notes";

    public ListNotesCommand(Presenter pre, Scanner s) {
        super(NAME, pre, s);
    }

    @Override
    public void execute() {
        presenter.showAllNotes();
    }
}

