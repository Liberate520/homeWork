package Views.Commands;

import Views.Executable;

public class CommandQuit implements Command {
    
    private Executable view;

    public CommandQuit(Executable view) {
        this.view = view;
    }

    @Override
    public String getInfo() {
        return "Quit";
    }

    @Override
    public void execute() {
        view.quit();
    }

    @Override
    public String getHelp(int number) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%d. Menu item \'%s\':\n", number, getInfo()));
        builder.append(String.format("\tENTER: \'%d\'\n", number));
        return builder.toString();
    }
}
