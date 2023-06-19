package Views.Commands;

import Views.Executable;

public class CommandRemove implements Command {

    private Executable view;

    public CommandRemove(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Remove";
    }

    @Override
    public void execute() {
        view.remove();
    }

    @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tENTER: \'%d/[ID]\'\n", number));
        return builder.toString();
    }
}
