package ui.commands.setCommands;

import human.Family;
import human.Human;
import ui.Console;

public class SetHuman {
    private Console console;
    private Integer index = -1;
    public SetHuman(Console console) {
        this.console = console;
        System.out.println("Выберите человека из списка" + parentsList());
        index = this.console.getScanner().nextInt()-1;
    }

    public String parentsList(){
        String humans = "";
        Integer i = 1;
        for (Human<Family> human : Console.humans) {
            humans = humans +" " + i++ +")"+ human.toString();
        }
        return humans;
    }

    public Integer getIndex() {
        return index;
    }
    
}
