package view.commands;

import view.View;

public class Exit implements Command{
    private View view;

    public Exit(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Завершение работы";
    }

    @Override
    public void execute() {
        view.exit();
    }
}
