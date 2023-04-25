package ui.questions;

import ui.Console;

public class RepeatHuman extends Question{

    public RepeatHuman(Console console){
        super(console);
    }
    @Override
    public String getDescription() {
        return "Человек уже есть в дереве. Заменить Y/N?";
    }

    @Override
    public String answer() {
        return getConsole().getAnswerRepeatHuman(this);
    }
}
