package homeWork.familytree;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new Tree();

        FamilyMember john = new FamilyMember("John", LocalDate.of(1980, 5, 15));
        FamilyMember mary = new FamilyMember("Mary", LocalDate.of(1982, 8, 20));

        john.addChild(new FamilyMember("Alice", LocalDate.of(2005, 3, 10)));
        mary.addChild(new FamilyMember("Bob", LocalDate.of(2008, 9, 5)));

        tree.addMember(john);
        tree.addMember(mary);

        List<FamilyMember> members = tree.getAllMembers();
        for (FamilyMember member : members) {
            System.out.println("Name: " + member.getName());
            List<FamilyMember> children = tree.getChildren(member.getName());
            for (FamilyMember child : children) {
                System.out.println("- Child: " + child.getName());
            }
        }
    }
}
