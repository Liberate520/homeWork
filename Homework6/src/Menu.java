import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<Command> commands;

    public Menu(ConsoleView console) {
        commands = new ArrayList<>();
        commands.add(new AddNote(console));
        commands.add(new PrintAll(console));
        commands.add(new Finish(console));
    }

    public String printMenu(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n======== Главное меню ========\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append("\t");
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).description());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    void execute(int num){
        Command option = commands.get(num);
        option.execute();
    }
}
