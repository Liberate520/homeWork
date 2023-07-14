package homeWork.FamalyTree.view.Commands;

import homeWork.FamalyTree.view.ConsoleUI;

public class GetHumanInfo extends Command{
    public GetHumanInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Вывести семейное дерево";
    }

    public void execute(){
        consoleUI.getHumanInfo();
    }
}
