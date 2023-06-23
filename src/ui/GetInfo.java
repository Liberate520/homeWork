package ui;

public class GetInfo implements Command {
    private Console console;

    public GetInfo(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Получить список родственников";
    }

    @Override
    public void execute() {
        console.getInfo();
    }
}