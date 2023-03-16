import java.util.Date;

import cmdui.FamilyTreeCmd;
import cmdui.commands.CommandFactory;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;
import familytree.FamilyTreeMemeberFactory;
import familytree.serializer.FamilyTreeSerializer;

/**
 * 
 */
public class Main {
    public static void main(String[] args) {
        try {
            var serializer = new FamilyTreeSerializer();
            FamilyTree<FamilyTreeMemeber> familyTree = serializer.load();
            if (familyTree == null) {
                familyTree = createFamilyTree();
                familyTree.save(serializer);
            }
            System.out.printf("Генеалогическое древо состоит из %d человек\n", familyTree.total());
            new FamilyTreeCmd(new CommandFactory());
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
    }

    private static FamilyTree<FamilyTreeMemeber> createFamilyTree() throws Exception {
        var familyTree = new FamilyTree<FamilyTreeMemeber>(new FamilyTreeMemeberFactory());
        int[] ids = new int[2];
        ids[0] = familyTree.addChild("Николай Лысенко", "мужской", date(5, 2, 40)).id();
        ids[1] = familyTree.addSpouse("Светлана Петрова", date(20, 10, 45), ids[0]).id();
        ids[0] = familyTree.addChild("Роман Лысенко", "мужской", date(4, 7, 65), ids).id();
        ids[1] = familyTree.addSpouse("Мария Федорова", date(6, 3, 72), ids[0]).id();
        ids[0] = familyTree.addChild("Иван Лысенко", "мужской", date(14, 8, 95), ids).id();
        ids[1] = familyTree.addSpouse("Анна Владимирова", date(26, 6, 99), ids[0]).id();
        ids[0] = familyTree.addChild("Ольга Лысенко", "женский", date(30, 9, 120), ids).id();
        return familyTree;
    }

    private static Date date(int day, int month, int year) {
        return new Date(year, month, day);
    }
}