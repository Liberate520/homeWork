package ui;

import java.util.ArrayList;
import java.util.List;

import presenter.Presenter;
import ui.commands.AddNewPerson;
import ui.commands.Exit;
import ui.commands.FindPerson;
import ui.commands.LivingPerson;
import ui.commands.Option;
import ui.commands.OutputTree;
import ui.commands.SortByBirthdate;
import ui.commands.SortByName;

public class Menu {
    private List<Option> commands;

    public Menu(ConsoleUi consoleUi, Presenter presenter) {
        commands = new ArrayList<>();
        commands.add(new OutputTree(presenter));
        commands.add(new LivingPerson(presenter));
        commands.add(new SortByName(presenter));
        commands.add(new SortByBirthdate(presenter));
        commands.add(new FindPerson(presenter));
        commands.add(new AddNewPerson(presenter));
        commands.add(new Exit(presenter));
    }

    public String execute(int num){
        Option option = commands.get(num-1);
        return option.execute();
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
