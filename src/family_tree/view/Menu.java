package family_tree.view;


import java.util.ArrayList;
import java.util.List;
import family_tree.view.commands.*;

public class Menu {
    private final List<Command> commandList;
    Menu_3 menu_3;
    Menu_1 menu_1;


    public Menu(ConsoleUI consoleUI) {
        menu_3 = new Menu_3();
        menu_1 = new Menu_1();

        commandList = new ArrayList<>();
        commandList.add(new Print_treeInfo(consoleUI));
        commandList.add(new Add_human(consoleUI));
        commandList.add(new Set_relatives(consoleUI));
        commandList.add(new ClearFamilyTree(consoleUI));
        commandList.add(new Load_file(consoleUI));
        commandList.add(new SaveFamilyTree(consoleUI));
        commandList.add(new Exit(consoleUI));

    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
