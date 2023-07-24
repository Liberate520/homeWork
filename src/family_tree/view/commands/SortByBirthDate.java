package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class SortByBirthDate extends Command{
    public SortByBirthDate(ConsoleUi consoleUi){
        super(consoleUi, ": Сортировать по возрасту");
    }
    public void execute(){
        consoleUi.sortByBirthDate();
    }
}
