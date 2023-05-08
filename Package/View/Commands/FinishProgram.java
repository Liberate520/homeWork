package Package.View.Commands;

import Package.View.Console;

public class FinishProgram implements Commander{
    private Console console;

    public FinishProgram(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Завершить работу с деревом";
    }

    @Override
    public void execute() {
        console.exit();
    }
}
