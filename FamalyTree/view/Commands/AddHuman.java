package homeWork.FamalyTree.view.Commands;

import homeWork.FamalyTree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавте члена семьи";
    }    

    public void execute(){
        consoleUI.addHuman();
    }
}
