public class PrintTree extends Command {
    public PrintTree(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Показать все записи";
    }

    @Override
    public void execute() {
        super.getConsole().printTree();
    }
}