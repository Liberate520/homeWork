package familyTree.src.family_tree.view.Commands;
import familyTree.src.family_tree.view.ConsoleUI;
public class SortByBirthDate extends Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по дате рождения";
    }

    public void execute(){ consoleUI.sortByBirthDate();
    }
}
