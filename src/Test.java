import java.io.*;

public class Test {
    public static void main(String[] args) {
        Human nick = new Human("Никита Петров", 22, Gender.male);
        Human mama = new Human("Елена Петрова", 45, Gender.female);
        Human papa = new Human("Евгений Петров", 46, Gender.male);
        nick.setMother(mama);
        nick.setFather(papa);

        FamilyTree family = new FamilyTree();
        family.addHuman(nick);
        family.addHuman(mama);
        family.addHuman(papa);

        Human brother = new Human("Лев Петров", 15, Gender.male, mama, papa);
        Human sister = new Human("Анастасия Петрова", 6, Gender.female, mama, papa);
        family.addHuman(brother);
        family.addHuman(sister);


        mama.showKids();
        System.out.println();
        nick.findSiblings();
        System.out.println();
        brother.findSiblings();
        System.out.println();

        System.out.println(family.showAllRelatives());
        family.sortByName();
        System.out.println(family.showAllRelatives());
        family.sortByAge();
        System.out.println(family.showAllRelatives());

        String filePath = "family.txt";
        Writable writable = new Serialization();

        writable.save(family, filePath);

        FamilyTree tree = writable.read(filePath);
        System.out.println(family.showAllRelatives());
    }
}
