package Views.Commands;

import Views.Executable;

public class CommandUpdate implements Command {

    private Executable view;

    public CommandUpdate(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Edit";
    }

    @Override
    public void execute() {
        view.update();
    }

         @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tENTER: \'%d/[ID]/[HEADER]/[CONTENT]/[AUTHOR]\'\n", number));
        return builder.toString();
    }
}
