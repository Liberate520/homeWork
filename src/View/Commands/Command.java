package View.Commands;

import View.ViewConsole;

public abstract class Command implements Option {
    private String description;
    private ViewConsole viewConsole;

    public Command (ViewConsole viewConsole){
        this.viewConsole = viewConsole;
    }
    public ViewConsole getViewConsole(){
        return viewConsole;
    }
    public abstract String getDescription();
    public abstract void execute();

}
