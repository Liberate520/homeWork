package ui.Commands;

import ui.View;

public class Exit extends Command {

    public Exit(View view) {
        super(view);
    }

    @Override
    public String description() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        getView().print("Завершение...");
        System.exit(0);
    }
    
}
