import java.util.Date;
import cmdui.FamilyTreeCmd;
import cmdui.commands.CommandFactory;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;
import familytree.serializer.FamilyTreeSerializer;
import presenter.Presenter;

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
            var view = new FamilyTreeCmd(new CommandFactory());
            var presenter = new Presenter(view, familyTree);
            view.run();
        } catch (NumberFormatException e) {
        } catch (Exception e) {
            System.out.printf("Ошибка: %s", e.getMessage());
        }
    }

    private static FamilyTree<FamilyTreeMemeber> createFamilyTree() throws Exception {
        var familyTree = new FamilyTree<FamilyTreeMemeber>();
        FamilyTreeMemeber[] ms = new FamilyTreeMemeber[2];
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Николай Лысенко", "мужской", date(5, 2, 40), null));
        ms[1] = familyTree.addMember(ms[0].addSpouse("Светлана Петрова", date(20, 10, 45)));
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Роман Лысенко", "мужской", date(4, 7, 65), ms));
        ms[1] = familyTree.addMember(ms[0].addSpouse("Мария Федорова", date(6, 3, 72)));
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Иван Лысенко", "мужской", date(14, 8, 95), ms));
        ms[1] = familyTree.addMember(ms[0].addSpouse("Анна Владимирова", date(26, 6, 99)));
        ms[0] = familyTree.addMember(new FamilyTreeMemeber("Ольга Лысенко", "женский", date(30, 9, 120), ms));
        return familyTree;
    }

    private static Date date(int day, int month, int year) {
        return new Date(year, month, day);
    }
}