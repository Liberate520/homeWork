package ui.commands;

import presenter.Presenter;

public class Exit implements Option{

    private Presenter presenter;

    public Exit(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Ввыйти из программы";
    }

    @Override
    public String execute() {
        return presenter.exit();
    }
    
}
