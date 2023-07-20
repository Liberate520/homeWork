package View.Commands;

import View.ViewConsole;

public class AllObjectInfo extends Command{
    public AllObjectInfo(ViewConsole viewConsole) {
        super(viewConsole);
    }

    @Override
    public String getDescription() {
        return "Получить информацию о всех объектах";
    }

    @Override
    public void execute() {
        getViewConsole().allObjectInfo();

    }
}
