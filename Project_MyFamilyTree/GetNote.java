package Project_MyFamilyTree;

public class GetNote implements Command{

    private Console console;

    public GetNote(Console console){
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Введите имя человека (через пробел)";
    }

    @Override
    public void execute() {
        console.getNote();
    }
    
}
