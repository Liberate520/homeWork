package homeWork.FamalyTree.view.Commands;

import java.io.File;

import homeWork.FamalyTree.view.ConsoleUI;

public class SaveData extends Command {
    public SaveData(ConsoleUI consoleUI){
        super(consoleUI);
        
        description = "Сохранить дерево";
    }    

    public void execute(){
        File file = new File("homeWork\\FamalyTree\\Hanler.txt");
        consoleUI.SaveData(file);
    }
}
