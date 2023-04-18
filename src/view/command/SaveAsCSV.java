package view.command;

import java.util.LinkedHashMap;

import view.ConsoleUI;

public class SaveAsCSV extends Commands {
    private final String name = "save as csv";
    private final String help = "save as csv: - сохраняет данные в csv файл\n";

    public SaveAsCSV(ConsoleUI console) {
        super(console);
        super.setCommandName(this.name);
        super.setCommandHelp(this.help);
    }


    @Override
    public void execute(LinkedHashMap<String, String> map) {
        this.getConsole()
                .getPresenter()
                .commandFileSaveAsCSV();
    }
    
}
