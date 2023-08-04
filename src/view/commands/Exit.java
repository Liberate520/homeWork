package view.commands;

import presenter.Presenter;

public class Exit implements Command{

    @Override
    public void start(Presenter presenter) {
        System.exit(0);
    }

    @Override
    public String getDescription() {
        return "Exit";
    }
}
