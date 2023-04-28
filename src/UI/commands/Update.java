package UI.commands;

import UI.Console;

import java.io.IOException;

public class Update implements Command {
    private Console console;

    public Update(Console console) {
        this.console = console;
    }

    @Override
    public String description() {
        return "Сохранить измененное дерево";
    }

    @Override
    public void run() throws IOException {
        console.update();
    }
}
