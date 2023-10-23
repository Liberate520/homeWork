package homeWork3.ui;

public class PrintFamily extends Command {

    public PrintFamily(Console console) {
        super(console);
    }

    @Override
    public String details() {
        return "Печать семейного древа.";
    }

    @Override
    public void execute() {
        getConsole().printFamily();
    }
}
