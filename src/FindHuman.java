import java.util.Scanner;

public class FindHuman {

    public void findHuman(FamilyTree familyTree) {
        System.out.printf("Введите имя для поиска: ");
        Scanner scn = new Scanner(System.in, "cp866");
        String findName = scn.nextLine();
        scn.close();

        boolean find = false;
        for (int i = 0; i < familyTree.getFamilyTree().size(); i++) {
            if (familyTree.getFamilyTree().get(i).getName().contains(findName)) {
                System.out.println(familyTree.getFamilyTree().get(i));
                find = true;
            }
        }
        if (!find)
            System.out.println("Такой человек не найден.");
    }
}
