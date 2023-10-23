import ru.gb.f_tree.f_tree.FamilyTree;
import ru.gb.f_tree.human.Gender;
import ru.gb.f_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем семью "Smith"
        FamilyTree smithFamily = new FamilyTree("Smith");

        // Создаем некоторых людей
        Human willSmith = new Human("Smith", "Will", Gender.Male);
        willSmith.setBirthday(LocalDate.of(1968, 9, 25));
        smithFamily.addMember(willSmith);

        Human jadaPinkett = new Human("Pinkett", "Jada", Gender.Female);
        jadaPinkett.setBirthday(LocalDate.of(1971, 9, 18));
        smithFamily.addMember(jadaPinkett);

        willSmith.setSpouse(jadaPinkett);

        Human jadenSmith = new Human("Smith", "Jaden", Gender.Male);
        jadenSmith.setBirthday(LocalDate.of(1998, 7, 8));
        smithFamily.addMember(jadenSmith);

        Human willowSmith = new Human("Smith", "Willow", Gender.Female);
        willowSmith.setBirthday(LocalDate.of(2000, 10, 31));
        smithFamily.addMember(willowSmith);

        willSmith.setChild(jadenSmith);
        jadaPinkett.setChild(jadenSmith);
        willSmith.setChild(willowSmith);
        jadaPinkett.setChild(willowSmith);

        // Вывод информации о семье Smith
        System.out.println("Семья Smith:");
        List<Human> smithFamilyMembers = smithFamily.getFamilyMembers();
        for (Human member : smithFamilyMembers) {
            System.out.println(member.getFullName());
        }

        // Создаем еще одну семью "Jones" с другими людьми
        FamilyTree jonesFamily = new FamilyTree("Jones");

        Human tomJones = new Human("Jones", "Tom", Gender.Male);
        tomJones.setBirthday(LocalDate.of(1940, 6, 7));
        jonesFamily.addMember(tomJones);

        Human priscillaJones = new Human("Jones", "Priscilla", Gender.Female);
        priscillaJones.setBirthday(LocalDate.of(1945, 5, 24));
        jonesFamily.addMember(priscillaJones);

        tomJones.setSpouse(priscillaJones);

        Human elvisJones = new Human("Jones", "Elvis", Gender.Male);
        elvisJones.setBirthday(LocalDate.of(1971, 3, 15));
        jonesFamily.addMember(elvisJones);

        tomJones.setChild(elvisJones);
        priscillaJones.setChild(elvisJones);

        //  Вывод информации о семье Jones
        System.out.println("Информация о семье Jones:");
        List<Human> jonesFamilyMembers = jonesFamily.getFamilyMembers();
        for (Human member : jonesFamilyMembers) {
            System.out.println("Имя: " + member.getFullName());
            System.out.println("Возраст: " + member.getAge());
            System.out.println("ID: " + member.getId());

            List<Human> children = jonesFamily.getChildrenOf(member);
            if (!children.isEmpty()) {
                System.out.println("Дети:");
                for (Human child : children) {
                    System.out.println("- " + child.getFullName());
                }
            }

            List<Human> parents = jonesFamily.getParentsOf(member);
            if (!parents.isEmpty()) {
                System.out.println("Родители:");
                for (Human parent : parents) {
                    System.out.println("- " + parent.getFullName());
                }
            }

            System.out.println();
        }
    }
}
