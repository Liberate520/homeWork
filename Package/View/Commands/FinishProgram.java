package Package.View.Commands;

import Package.View.Console;

public class FinishProgram implements Commander{
    private String description;
    private Console console;

    public FinishProgram(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Удалить существующего человека из дерева";
    }

    @Override
    public void execute() {
        console.exit();
    }
}
