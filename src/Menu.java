
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Option> commands;
    private Console console;
    public Menu(Console console) {
        this.console = console;
        commands = new ArrayList<>();
        commands.add(new AddEntry(console));
        commands.add(new ShowEntry(console));
        commands.add(new ShowAllEntries(console));
        // commands.add(new DeleteEntry(console));
        commands.add(new Save(console));
        commands.add(new Load(console));
        commands.add(new Exit(console));
    }
    void execute(int num) throws IOException{
        Option option = commands.get(num - 1);
        option.execute();
    }
    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(": ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Option> getCommands() {
        return commands;
    }
}