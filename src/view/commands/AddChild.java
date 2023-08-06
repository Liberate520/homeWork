package src.view.commands;
import src.view.ConsoleUI;
public class AddChild  extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка ...";
    }
    @Override
    public void execute(){
        consoleUI.AddChild();
    }
}
