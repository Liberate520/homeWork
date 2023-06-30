package Project_MyFamilyTree_MVP;

public class NewHuman implements Command {
    private Console console;      

    public NewHuman (Console console){
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Создать нового человека в древе";
    }

    @Override
    public void execute() {
        console.NewHuman();
    }
}
