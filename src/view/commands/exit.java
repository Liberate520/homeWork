package view.commands;

import view.View;

public class exit implements Command{
    private View view;

    public exit(View view) {
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
