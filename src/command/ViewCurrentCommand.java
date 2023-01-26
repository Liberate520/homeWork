package command;

import view.ConsoleUI;

public class ViewCurrentCommand extends Command{

    public ViewCurrentCommand(ConsoleUI view, String title) {
        super(view, title);
    }

    @Override
    public String description() {
        String oldDescr = super.description();
        int lineIndex = oldDescr.indexOf("\n");
        String line = oldDescr.substring(0, lineIndex);
        String descr = line +  " (current: \"" + view.getPresenter().onGetTreeName() + "\")" + oldDescr.substring(lineIndex);
        return descr;
    }
}
