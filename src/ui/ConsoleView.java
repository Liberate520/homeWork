package ui;

import presenter.Presenter;
import ui.command.Command;
import ui.command.CreateNewNoteCommand;
import ui.command.DeleteNoteCommand;
import ui.command.ListNotesCommand;
import ui.command.ChangeNoteCommand;


import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);
    private final Presenter presenter;

    public ConsoleView() {
        this.presenter = new Presenter();
    }

    public void run() {
        while (true) {
            final List<Command> commandList = getCommands();
            System.out.println("=====================");
            System.out.println("Available commands:");
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i + 1 + " - " + commandList.get(i).getName());
            }
            System.out.println("=====================");
            System.out.println("Type command then hit enter: ");
            if (scanner.hasNextInt()){
                final int commandCode = scanner.nextInt();
                if(commandCode > 0 && commandCode <= commandList.size()) {
                    commandList.get(commandCode-1).execute();
                }
            }
        }
    }

    private List<Command> getCommands() {
        return List.of(new CreateNewNoteCommand(presenter, scanner),
                new ListNotesCommand(presenter, scanner),
                new DeleteNoteCommand(presenter, scanner),
                new ChangeNoteCommand(presenter, scanner));
    }
}

