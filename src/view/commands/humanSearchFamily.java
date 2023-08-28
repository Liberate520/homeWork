package src.view.commands;
import src.view.ConsoleUI;
public class humanSearchFamily extends Command  {

    public humanSearchFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти человека и семью ...";
    }
    @Override
    public void execute(){
        consoleUI.humanSearchFamily();
    }
}
