package ui.Commands;

import ui.View;

public class Finish implements Command {
    public View view;
    public Finish(View view){
        this.view=view;
    }

    @Override
    public String getDescription() {
        return "закончить работу:";
    }

    @Override
    public void execute() {
        view.Finish();
    }
}

