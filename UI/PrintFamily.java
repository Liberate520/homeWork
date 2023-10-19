package homeWork3.UI;

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
