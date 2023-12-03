import model.Service;
import model.human.Gender;
import model.tree.FamilyTree;
import model.writer.FileHandler;
import view.ConsoleUI;

public class Main {
    public static void main(String[] args) {

        /*Service service = new Service();

        service.addHuman("Виталий", "Яванов", Gender.Male);
        service.addHuman("Екатерина", "Иванова", Gender.Female);
        service.addHuman("Анна", "Степанова", Gender.Female);

        System.out.println(service);
        service.sortByName();
        System.out.println(service);
        service.sortBySurname();
        System.out.println(service);*/

        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.start();

    }
}