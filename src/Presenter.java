import java.io.IOException;


public class Presenter{
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public Human сreateHuman() {
        return service.сreateHuman();
    }

    public void getHumanByName() {
        service.getHumanByName();
    }

    public void print() {
        service.print();
    }

    public void createTree() {
        service.createTree();
    }

    public void printChildren() {
        service.printChildren();
    }

    public void writeInFile() throws IOException {
        service.writeInFile();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        service.readFromFile();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirth() {
        service.sortByBirth();
    }

    public void addHuman(Human human) {
        service.addHuman(human);
    }

}