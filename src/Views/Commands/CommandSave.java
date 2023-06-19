package Views.Commands;

import Views.Executable;

public class CommandSave implements Command {

    private Executable view;

    public CommandSave(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Save";
    }

    @Override
    public void execute() {
        view.save();
    }

    @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tENTER: \'%d\'\n", number));
        return builder.toString();
    }
}
