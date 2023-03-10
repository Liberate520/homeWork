import java.io.FileNotFoundException;
import java.io.IOException;

public class Load extends Command {
    public Load(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Load from file";
    }

    @Override
    public void execute() throws FileNotFoundException, IOException {
        super.getConsole().load();
    }
}