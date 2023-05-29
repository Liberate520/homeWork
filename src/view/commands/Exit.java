package view.commands;

import view.View;


public class Exit extends CommandsAbstract{

    public Exit(View view) {
        super(view, 0, "Exit.");
    }

    @Override
    public void execute() {
        System.out.println("Good buy!!!");
        getView().changeFlag();
    }
}
