package view.commands;

import view.View;

public abstract class CommandsAbstract implements Command{
    private String description;
    private View view;
    private Integer number;

    public CommandsAbstract(View view, Integer number, String description) {
        this.description = description;
        this.view = view;
        this.number = number;
    }

    @Override
    public String getDescription() {
        return this.number + ". " + this.description;
    }
    public Integer getNumber() {
        return this.number;
    }
    public View getView() {
        return this.view;
    }
    public abstract void execute();
}
