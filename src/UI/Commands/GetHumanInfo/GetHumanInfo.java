package UI.Commands.GetHumanInfo;

import FamilyTree.FamilyTree;
import Human.Human;
import UI.Commands.Command;
import UI.Console;

public class GetHumanInfo extends Command {

    FamilyTree<Human> familyTree;

    public GetHumanInfo(Console console) {
        super(console);
    }


    @Override
    public String getDescription() {
        return "Посмотреть сведения о человеке";
    }

    @Override
    public void execute() {
        getConsole().getHumanInfo();
    }

}
