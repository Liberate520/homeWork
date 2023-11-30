package family_tree.family_tree.view.commands;

import family_tree.family_tree.view.ConsoleUI;

public class GetHumanListInfo extends Command {

    public GetHumanListInfo(ConsoleUI view) {
        super("Получить список Human", view);
    }

    public void execute(){
        getView().getHumanListInfo();
    }

}
