package FamilyTree.view.commands;

import FamilyTree.view.View;

public class SetMarriage extends Command {

    public SetMarriage(View view) {
        super("Свадьба.", view);
    }

    public void execute(){ getView().setMarriage(); }
}
