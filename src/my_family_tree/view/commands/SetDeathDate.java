package my_family_tree.view.commands;

import my_family_tree.view.View;

public class SetDeathDate extends Command {

    public SetDeathDate(View view) {
        super("Добавить дату смерти", view);
    }

    public void execute(){
        view.setDeathDate();
    }
}
