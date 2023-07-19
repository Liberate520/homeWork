package homeWork.FamalyTree.view.Commands;

import java.io.File;

import homeWork.FamalyTree.view.ConsoleUI;

public class LoadData extends Command {
    public LoadData(ConsoleUI consoleUI){
        super(consoleUI);
        
        description = "Загрузить дерево";
    }    

    public void execute(){
        File file = new File("homeWork\\FamalyTree\\Hanler.txt");
        consoleUI.LoadData(file);
    }
}
