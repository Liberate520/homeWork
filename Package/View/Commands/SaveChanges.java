package Package.View.Commands;

import Package.View.Console;

public class SaveChanges implements Commander{
    private Console console;
    public SaveChanges(Console console){
        this.console = console;
    }
    @Override
    public String getDescription() {
        return "Сохранить изменения";
    }

    @Override
    public void execute() {
        console.save();
    }
}
