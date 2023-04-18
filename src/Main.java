import model.Service;
import presenter.Presenter;
import view.ConsoleUI;
import view.command.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // Service service = new Service("bd.csv","csv");

        Service service = new Service("bd.bin", "binary");
        ConsoleUI console = new ConsoleUI();

        console.addCommands(new NotFound(console));
        console.addCommands(new Show(console));
        console.addCommands(new SortByName(console));
        console.addCommands(new SortById(console));
        console.addCommands(new Id(console));
        console.addCommands(new SaveAsCSV(console));
        console.addCommands(new SaveAsBinary(console));
        console.addCommands(new New(console));
        console.addCommands(new SearchByName(console));
        console.addCommands(new AddSexMale(console));
        console.addCommands(new AddSexFemale(console));
        console.addCommands(new AddMother(console));
        console.addCommands(new AddFather(console));

        

        new Presenter(service, console);

        console.start();
    }

}
