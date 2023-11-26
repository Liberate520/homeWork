package FamilyTree.view.commands;

import FamilyTree.view.View;

public class Finish extends Command{

    public Finish(View view) {
        super("Завершение работы.", view);
    }

    public void execute(){ getView().finish(); }
}
