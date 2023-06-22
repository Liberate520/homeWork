package Project_MyFamilyTree;


public class Finish implements Command{
    private Console console;

    public Finish(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Закончить работу";
    }

    @Override
    public void execute() {
        console.finish();
    }
}
