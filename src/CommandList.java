import java.util.ArrayList;
import java.util.List;

public class CommandList<E extends TreeOptions> {

    private List<E> commands;

    public CommandList(List<E> commands) {
        this.commands = commands;
    }

    public CommandList() {
        this(new ArrayList<>());
    }

    public void setCommands(List<E> commands1) {
        this.commands = commands1;
    }

    public void addCommand(E com) {
        commands.add(com);
    }

    public List<E> getCommandList() {
        return commands;
    }

    public E getCommand(int i) {
        return commands.get(i);
    }

    public int size() {
        return commands.size();
    }

}