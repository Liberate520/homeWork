package ui.commands;

import presenter.Presenter;

public class LivingPerson implements Option{
    Presenter presenter;

    public LivingPerson(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public String description() {
        return "Ввывести список живых людей";
    }

    @Override
    public String execute() {
        return presenter.livingHuman();
    }
    
}
