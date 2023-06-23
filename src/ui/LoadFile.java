package ui;

public class LoadFile implements Command {
    private Console console;

    public LoadFile(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Распечатать дерево из файла";
    }

    @Override
    public void execute() {
        console.loadFile();
    }
}
