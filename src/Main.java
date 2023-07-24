import Model.Person.Person;
import View.ConsoleView;
import View.View;

public class Main {
    public static void main(String[] args) {
        View app = new ConsoleView<Person>();
        app.start();
    }
}
