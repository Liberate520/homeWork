import java.util.Date;
import java.util.Scanner;

/**
 * Добавлен класс для сериализации генеалогического древа FamilyTreeSerializer и интерфейсы для работы с ним.
 */
public class Main {
    public static Scanner sc;

    public static void main(String[] args) {
        try {
            sc = new Scanner(System.in);
            FamilyTree familyTree = createFamilyTree();
            System.out.printf("Генеалогическое древо состоит из %d человек\n" +
                    "  Введите ID человека (цифра от 1 до %d) для просмотра информации о нем\n" +
                    "  Введите 0 для просмотра информации обо всех\n" +
                    "  Enter - выход\n", familyTree.total(), familyTree.total());
            while (true) {
                String input = sc.nextLine();
                int num = Integer.parseInt(input) - 1;
                if (num < 0) {
                    System.out.println(familyTree);
                } else if (num >= familyTree.total()) {
                    System.out.println("Неверный ID");
                } else {
                    FamilyTreeMemeber memeber = familyTree.getMemeberById(num);
                    System.out.println(memeber);
                }
            }
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        } finally {
            if (sc != null)
                sc.close();
        }
    }

    private static FamilyTree createFamilyTree() throws Exception {
        var serializer = new FamilyTreeSerializer();
        FamilyTree familyTree = serializer.load();
        if (familyTree != null)
            return familyTree;
        familyTree = new FamilyTree();
        int[] ids = new int[2];
        ids[0] = familyTree.addChild("Николай Лысенко", "мужской", date(5, 2, 40)).id();
        ids[1] = familyTree.addSpouse("Светлана Петрова", date(20, 10, 45), ids[0]).id();
        ids[0] = familyTree.addChild("Роман Лысенко", "мужской", date(4, 7, 65), ids).id();
        ids[1] = familyTree.addSpouse("Мария Федорова", date(6, 3, 72), ids[0]).id();
        ids[0] = familyTree.addChild("Иван Лысенко", "мужской", date(14, 8, 95), ids).id();
        ids[1] = familyTree.addSpouse("Анна Владимирова", date(26, 6, 99), ids[0]).id();
        ids[0] = familyTree.addChild("Ольга Лысенко", "женский", date(30, 9, 120), ids).id();
        familyTree.save(serializer);
        return familyTree;
    }

    private static Date date(int day, int month, int year) {
        return new Date(year, month, day);
    }
}