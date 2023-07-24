import MVP.Model;
import MVP.Presenter;
import MVP.View;
import Models.Person.Person;
import UI.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Model<Person> model = new Model<>();
        View view = new ConsoleView();
        Presenter<Person> presenter = new Presenter<>(model, view);

        presenter.start();
    }
}
