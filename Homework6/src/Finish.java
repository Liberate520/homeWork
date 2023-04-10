public class Finish extends Command {
    public Finish (ConsoleView console) {
        super(console);
    }
    @Override
    public String description() {
        return "Завершить работу";
    }

    public void execute() {
        getConsole().finish();
    }
}
