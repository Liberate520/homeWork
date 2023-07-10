import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.saveload.FileHandler;
import ru.gb.family_tree.tree.FamilyTree;
import java.time.LocalDate;

public class Main {
    
    public static void main(String[] args) {

        // Наполнение дерева
        FamilyTree<Human> ft = new FamilyTree<>();
        Human im = new Human("Хаустов", "Евгений", "Владимирович", Gender.Male.toString(), LocalDate.of(1996, 5, 6));
        Human mom = new Human("Хаустова", "Юлия", "Юрьевна", Gender.Female.toString(), LocalDate.of(1976, 2, 3));
        Human grandMom = new Human("Хаустова", "Александра", "Владимировна", Gender.Female.toString(), LocalDate.of(1955, 10, 11));

        mom.addChildInfo(im);
        grandMom.addChildInfo(mom);

        ft.addMember(im);
        ft.addMember(mom);
        ft.addMember(grandMom);

        // Сериализация дерева
        FileHandler fHandler = new FileHandler("obj.out");
        try {
            fHandler.write(ft);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Десериализация дерева
        System.out.println("Десериализация");
        try {
            FamilyTree<Human> familyTree = (FamilyTree<Human>) fHandler.read();
            familyTree.getTreeMembers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Сортировка по дате рождения
        System.out.println("Сортировка по дате рождения");
        ft.sortByBirthDate();
        ft.getTreeMembers();

        // Сортировка по фамилии
        System.out.println("Сортировка по имени");
        ft.sortByName();
        ft.getTreeMembers();

        // Проверка итератора
        System.out.println("Итерация FamilyTree через foreach");
        for (Human human : ft) System.out.println(human);
    }
}
