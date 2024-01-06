import ru.gb.model.treeItem.Gender;
import ru.gb.model.person.Person;
import ru.gb.model.service.Service;
import ru.gb.view.ConsoleUI;
import ru.gb.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View app = new ConsoleUI();

        app.start();
    }
}
