package family_tree.view.commands;

import family_tree.view.ConsoleUi;

public class GetInfo extends Command{
    public GetInfo(ConsoleUi consoleUi){
        super(consoleUi, ": Вывести всех членов семьи");
    }
    public void execute(){
        consoleUi.getInfo();
    }
}
