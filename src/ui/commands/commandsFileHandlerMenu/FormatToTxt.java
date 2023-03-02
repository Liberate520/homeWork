package ui.commands.commandsFileHandlerMenu;

import ui.Console;
import ui.commands.Option;

public class FormatToTxt extends Option{
    public FormatToTxt(Console console) {
        super(console);
    }

    @Override
    public String descriprion() {
        return "Импортировать в txt файл.";
    }

    @Override
    public void execute() {
        getConsole().formatToTxt();
    }
}
