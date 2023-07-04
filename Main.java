import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human Аlexander = new Human("Аlexander", LocalDate.of(1987, 9, 21), Gender.male);
        Human Ekaterina = new Human("Ekaterina", LocalDate.of(1985, 12, 23), Gender.FEMALE);
        Human Timofei = new Human("Timofei", LocalDate.of(2013, 10, 06), Gender.male);
        Human Zahar = new Human("Zahar", LocalDate.of(2017, 12, 27), Gender.FEMALE);
        Аlexander.addChild(Zahar);
        Аlexander.addChild(Timofei);
        Timofei.addParent(Аlexander);
        Timofei.addParent(Ekaterina);
        Zahar.addParent(Аlexander);
        Zahar.addParent(Ekaterina);
        familyTree.addHuman(Аlexander);
        familyTree.addHuman(Ekaterina);
        familyTree.addHuman(Timofei);
        familyTree.addHuman(Zahar);
        List<Human> АlexandersChildren = familyTree.getAllChildren(Аlexander);
        System.out.println("Аlexander's children:");
        for (Human child : АlexandersChildren) {
            System.out.println(child.getName());          
        }
    }
}