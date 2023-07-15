package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddMarriage extends Command{
        public AddMarriage(ConsoleUI consoleUI) {
            super(consoleUI);
            description = "Зарегистрировать брак";
        }

        public void execute(){
            consoleUI.addMarriage();
        }
}
