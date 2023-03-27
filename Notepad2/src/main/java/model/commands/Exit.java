package model.commands;

public class Exit implements CommandsInterface{
    private final String NAME = "Выход.";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String result() {
        return "Выход";
    }
}
