package homeWork.FamalyTree.view.Commands;

import homeWork.FamalyTree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        consoleUI.finish();
    }
}
