package view.command;

import view.ConsoleUI;

public class ImportTree extends Command {

    public ImportTree(ConsoleUI console) {
        super(console);
        description = "Загрузить из текстового файла";
    }

    public void execute(){
        console.importTree();
    }
}
