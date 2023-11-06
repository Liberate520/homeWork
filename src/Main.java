import human.Gender;
import human.Human;
import tree.FamilyTree;
import writer.FileHandler;

public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        service.addHuman("Виталий", "Яванов", Gender.Male);
        service.addHuman("Екатерина", "Иванова", Gender.Female);
        service.addHuman("Анна", "Степанова", Gender.Female);

        System.out.println(service);
        service.sortByName();
        System.out.println(service);
        service.sortBySurname();
        System.out.println(service);

        write(service.getFamilyTree());

        Service s2 = new Service(load());
    }

    private static void write(FamilyTree familyTree) {
        String filepath = "src/text/tree.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(familyTree, filepath);
    }

    private static FamilyTree load() {
        String filepath = "src/text/tree.txt";
        FileHandler fileHandler = new FileHandler();
        FamilyTree familyTree = (FamilyTree) fileHandler.read(filepath);
        return familyTree;
    }
}