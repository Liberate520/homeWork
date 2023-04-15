package ui.optionConsole;

import ui.Console;

public class GetUnitInfo extends Option {

    public GetUnitInfo(Console console) {
        super(console);
        setDescription("Информация по члену семьи.");
    }

    @Override
    public void execute() {
        super.getConsole().getUnitInfo();
    }
}
