package FamilyTree_homework.view.commands;

import FamilyTree_homework.view.Console;

public abstract class Command {
        private String description;
        private Console console;
        public Command(String description, Console console) {
            this.description = description;
            this.console = console;
        }

        public String getDescription(){
            return description;
        }

        Console getConsole() {
            return console;
        }

        public abstract void execute();
}
