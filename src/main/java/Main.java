import org.json.JSONException;
import presenter.Controller;
import view.ConsoleTerminal;

public class Main {
    public static void main(String[] args) throws JSONException {
        ConsoleTerminal view = new ConsoleTerminal();
        Controller con = new Controller(view);
        view.start();
    }
}     
