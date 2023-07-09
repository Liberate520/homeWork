import java.time.LocalDate;
import ru.gb.family_tree.*;
import ru.gb.family_tree.saveload.*;

public class Main {
    
    public static void main(String[] args) {

        // Наполнение дерева
        FamilyTree ft = new FamilyTree();
        Human im  = new Human("Хаустов", "Евгений", "Владимирович", Gender.Male.toString(), LocalDate.of(1996, 05, 06));
        Human mom = new Human("Хаустова", "Юлия", "Юрьевна", Gender.Female.toString(), LocalDate.of(1976, 02, 03));
        Human grandMom = new Human("Хаустова", "Александра", "Владимировна", Gender.Female.toString(), LocalDate.of(1955, 10, 11));

        mom.addChildInfo(im);
        grandMom.addChildInfo(mom);

        ft.addHuman(im);
        ft.addHuman(mom);
        ft.addHuman(grandMom);

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
            FamilyTree familyTree = (FamilyTree) fHandler.read();
            familyTree.getHumans();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Сортировка по дате рождения
        System.out.println("Сортировка по дате рождения");
        ft.sortByBirthDate();
        ft.getHumans();

        // Сортировка по фамилии
        System.out.println("Сортировка по фамилии");
        ft.sortBySurname();
        ft.getHumans();

        // Проверка итератора
        System.out.println("Итерация FamilyTree через foreach");
        for (Human human : ft) System.out.println(human);
    }
}
