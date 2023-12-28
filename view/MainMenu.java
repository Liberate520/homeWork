package view;

import java.util.ArrayList;
import java.util.List;

import model.FamilyModel.*;
import model.HumanModel.*;
import model.service.*;
import presenter.Presenter;
import view.commands.AddFather;
import view.commands.AddHuman;
import view.commands.AddMather;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetParrents;
import view.commands.LoadFile;
import view.commands.PrintAll;
import view.commands.SaveInFile;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new SaveInFile(consoleUI));
        commandList.add(new LoadFile(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new AddMather(consoleUI));
        commandList.add(new AddFather(consoleUI));
        commandList.add(new GetParrents(consoleUI));
        commandList.add(new PrintAll(consoleUI));
        commandList.add(new Finish(consoleUI));

    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }

}
