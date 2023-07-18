package familyTree.src.family_tree.view.Commands;
import familyTree.src.family_tree.view.ConsoleUI;
public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}
