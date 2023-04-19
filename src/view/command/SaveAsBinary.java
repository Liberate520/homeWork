package view.command;

import java.util.LinkedHashMap;

import view.ConsoleUI;

public class SaveAsBinary extends Commands {
    private final String name = "save as binary";
    private final String help = "save as binary: - сохраняет данные в бинарный файл\n";

    public SaveAsBinary(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }

    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole()
                .getPresenter()
                .commandFileSaveAsBinary();
    }
    
}
