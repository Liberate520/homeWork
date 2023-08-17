package family_tree.view.commands.show;
import family_tree.view.ConsoleUI;
import family_tree.view.commands.Command;

public class ShowFamilyTreeInfo extends Command{

    public ShowFamilyTreeInfo(ConsoleUI consoleUi) {
        super(consoleUi, "Показать фамильное дерево.");
    }
    
    @Override
    public void execute() {
        super.consoleUi.getFamilyTreeInfo();
    }
}
