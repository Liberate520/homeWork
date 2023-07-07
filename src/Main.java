import java.time.LocalDate;
import ru.gb.family_tree.*;

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
            fHandler.writeObject(ft);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Десериализация дерева
        try {
            FamilyTree familyTree = (FamilyTree) fHandler.readObject();
            familyTree.getHumans();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
