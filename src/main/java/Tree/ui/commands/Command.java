package Tree.ui.commands;

import Tree.ui.Console;
// класс родитель для классов запускающих команды управления приложением
public abstract class Command implements Option {

    private Console console;

    // конструктор
    public Command(Console console) {
        this.console = console;
    }

    // геттер
    public Console getConsole() {
        return console;
    }
}
