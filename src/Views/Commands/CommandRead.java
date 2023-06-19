package Views.Commands;

import Views.Executable;

public class CommandRead implements Command {

    private Executable view;

    public CommandRead(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Read";
    }

    @Override
    public void execute() {
        view.read();
    }

    @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tENTER: \'%d/[ID]\'\n", number));
        builder.append(String.format("\tENTER: \'%d/[HEADER]\'\n", number));       
        return builder.toString();
    }
}