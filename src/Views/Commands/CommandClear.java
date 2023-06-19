package Views.Commands;

import Views.Executable;

public class CommandClear implements Command {

    private Executable view;

    public CommandClear(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Clear";
    }

    @Override
    public void execute() {
        view.clear();
    }


    @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tENTER: \'%d/[HEADER]/[CONTENT]/[AUTHOR]\'\n", number));
        return builder.toString();
    }
}
