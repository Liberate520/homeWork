import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    boolean inProgress = true;
    FileHandler fileHandler = new FileHandler();
    FamilyTree<Human> familyTree = new FamilyTree<>();
        
    Service service = new Service(familyTree, fileHandler);
    service.createTree();
    Scanner scanner = new Scanner(System.in);
    service.printInvitationForUser();
    while (inProgress) {
        int operationNumber = scanner.nextInt();
        switch (operationNumber) {
            case 0:
                System.out.println("Работа завершена");
                scanner.close();
                inProgress = false;
                break;
            case 1:
                service.printChildren();
                service.printInvitationForUser();
                break;
            case 2:
                service.writeInFile();
                System.out.println("Вы успешно сохранили список генеалогического древа");
                service.printInvitationForUser();
                break;
            case 3:
                System.out.println("Генеалогическое древо, прочитанное из файла:");
                service.readFromFile();
                service.print();
                service.printInvitationForUser();
                break;
            case 4:
                System.out.println("Для сортировки по имени введите цифру 1:\n" +
                        "для сортировки по году рождения введите цифру 2: \n");
                try {
                    int sortNumber = scanner.nextInt();
                    service.sortByParameter(sortNumber);
                    service.printInvitationForUser();
                } catch (Exception e) {
                    System.out.println("Ошибка ввода! " + e);
                }
                break;
            case 5:
                Human human = service.CreateHuman();
                service.addHuman(human);
                service.printInvitationForUser();
                break;
            case 6:
                service.getHumanByName();
                service.printInvitationForUser();
                break;
            default:
                System.out.println("Вы ввели некорректный номер операции!");
                service.printInvitationForUser();
        }
    }
    }
}