package familyTree.src.family_tree.view.Commands;
import familyTree.src.family_tree.view.ConsoleUI;
public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        consoleUI.finish();
    }
}
