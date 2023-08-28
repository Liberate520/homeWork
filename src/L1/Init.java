package L1;

public class Init {
    public void init() {
        Family_tree people = new Family_tree();
        people.fillPeople();
        Controller controller = new Controller();
        controller.userInput(people);
    }
}
