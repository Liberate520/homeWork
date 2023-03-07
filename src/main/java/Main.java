import org.json.JSONException;
import org.json.simple.parser.ParseException;
import presenter.Controller;
import view.ConsoleTerminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JSONException, IOException, ParseException {
        ConsoleTerminal view = new ConsoleTerminal();
        Controller con = new Controller(view);
        view.start();
    }
}     
