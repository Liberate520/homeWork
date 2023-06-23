package ui;

public class SaveFile implements Command {
    private Console console;

    public SaveFile(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Сохранить дерево в файл";
    }

    @Override
    public void execute() {
        console.saveFile();
    }
}
