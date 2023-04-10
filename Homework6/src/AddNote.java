public class AddNote extends Command {
    public AddNote(ConsoleView console) {
        super(console);
    }
    @Override
    public String description() {
        return "Добавить заметку";
    }

    public void execute() {
        getConsole().addNote();
    }
}
