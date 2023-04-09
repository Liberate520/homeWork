package model.commands;

public class Exit implements CommandsInterface{
    private final String NAME = "Выход. (комманда exit)";
    private final String KEY = "exit";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String result(String text) {

        return "Выход";
    }
}
