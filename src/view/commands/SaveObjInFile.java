package view.commands;


import view.Console;

public class SaveObjInFile extends Command {

    public SaveObjInFile(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Сохранить объекты в файл";
    }

    @Override
    public void execute() {
        System.out.println("Сохраняю...");
        getConsole().saveInFile();
    }
}
