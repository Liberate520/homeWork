package ui;

import java.util.ArrayList;
import java.util.List;

import ui.Commands.Command;
import ui.Commands.Finish;
import ui.Commands.CreatureCommands.AddCreature;
import ui.Commands.CreatureCommands.ViewInfoByNames;
import ui.Commands.FamilyCommands.ReadFamilyFromFile;
import ui.Commands.FamilyCommands.ViewFamily;
import ui.Commands.FamilyCommands.WriteFamilyToFile;

public class Menu {
    List<Command> commands;
    List<Command> famTreeCommands;
    List<Command> creatureCommands;

    public Menu(Console console) {
        commands = new ArrayList<>();
        commands.add(new AddCreature(console));
        commands.add(new WriteFamilyToFile(console));
        commands.add(new ReadFamilyFromFile(console));
        commands.add(new ViewFamily(console));
        commands.add(new ViewInfoByNames(console));
        commands.add(new Finish(console));

    }

    public void execute(int choice, List<Command> commList) {
        commList.get(choice - 1).execute();
    }

    public void printMenu(List<Command> commList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Выбери вариант:\n");
        for (int i = 0; i < commList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commList.get(i).getDescription());
            if (i < commList.size() - 1)
                stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

}
