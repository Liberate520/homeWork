package homeWork3.ui;

public class addHuman extends Command {
    public addHuman(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Добавить человека в семейное дерево. ";
    }

    @Override
    public void execute() {
        getConsole().addNewHuman();
    }
}