package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddHuman;
import view.commands.Command;
import view.commands.Exit;
import view.commands.PrintInformation;
import view.commands.ReadFile;
import view.commands.SortByAge;
import view.commands.SortByBirthdate;
import view.commands.SortByName;
import view.commands.WriteFile;

public class CommandList { // класс закрыт на изменения, но открыт для расширения - ОК

    private List<Command> commandList;

    public CommandList(Console console) {
        commandList = new ArrayList<>();
        commandList.add(new AddHuman(console));
        commandList.add(new PrintInformation(console));
        commandList.add(new SortByAge(console));
        commandList.add(new SortByBirthdate(console));
        commandList.add(new SortByName(console));
        commandList.add(new WriteFile(console));
        commandList.add(new ReadFile(console));

        commandList.add(new Exit(console));
    }

    public String showCommands() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int index = 0; index < commandList.size(); index++) {
            stringBuilder.append(index + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(index).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command actualCommand = commandList.get(choice - 1);
        actualCommand.execute();
    }

}
