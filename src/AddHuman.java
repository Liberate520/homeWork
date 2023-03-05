public class AddHuman extends Command{ 


    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить новую запись";
    }

    @Override
    public void execute() {
        getConsole().addHuman();
    }
}
