package Package.View.Commands;

import Package.View.Console;

public class ShowTree implements Commander{
    private Console console;

    public ShowTree(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Показать генеалогическое древо";
    }

    @Override
    public void execute() {
        console.showTree();
    }
}
