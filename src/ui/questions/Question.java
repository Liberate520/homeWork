package ui.questions;

import ui.Console;

import java.util.concurrent.ConcurrentSkipListMap;

public abstract class Question {
    private Console console;
    public Question(Console console){
        this.console = console;
    }
    public abstract String getDescription();
    public Console getConsole(){
        return console;
    }
    public abstract String answer();
}
