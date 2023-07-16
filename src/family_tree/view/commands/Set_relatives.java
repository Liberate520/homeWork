package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class Set_relatives extends Command{

    public Set_relatives(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Установить родственную связь;";
    }
    public void execute() {
        System.out.println("Заглушка");
//        consoleUI.set_relatives(menu_3.get_choice());
    }
}
