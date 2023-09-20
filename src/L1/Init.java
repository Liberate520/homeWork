package L1;

import java.io.IOException;

public class Init {
    public void init() throws IOException, ClassNotFoundException {
        Family_tree people = new Family_tree();
        people.fillPeople();
        Controller controller = new Controller();
        controller.userInput(people);
    }
}
