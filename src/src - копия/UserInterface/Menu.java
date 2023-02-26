package UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> commands;

    public Option getCommands(int n) {
        return commands.get(n);
    }

    public Menu() {
        commands = new ArrayList<>();
        commands.add(new addHuman());
        commands.add(new delHuman());
        commands.add(new allFamily());

    }
    void execute(int num){
        Option option = commands.get(num);
        option.execute();
    }
    public String printMenu(){
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < commands.size() ; i++) {
            stringbuilder.append(i + 1);
            stringbuilder.append(": ");
            stringbuilder.append(commands.get(i).description());
            stringbuilder.append("\n");

        }
        return stringbuilder.toString();
    }
}
