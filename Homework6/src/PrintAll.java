public class PrintAll extends Command{
    public PrintAll(ConsoleView console) {
        super(console);
    }
    @Override
    public String description() {
        return "Показать все заметки";
    }

    public void execute() {
        getConsole().getNotes();
    }
}
