package L1;

import java.util.Scanner;

public class FindPersonOrChildren {

    public static void findInfoAboutPerson(Family_tree people){
        System.out.println("input name");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        for (int i = 0; i < people.getPeople().size(); i++) {
            if (people.getPeople().get(i).getName().equals(lastName)){
                System.out.println("//////////////////////////////");
                System.out.println(people.getPeople().get(i));
                System.out.println("//////////////////////////////");
                return;
            }
        }
        System.out.println("no such person");
    }
    public static void findChildrenOfPerson(Family_tree people) {
        System.out.println("input name for finding children");
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        for (int i = 0; i < people.getPeople().size(); i++) {
            if (people.getPeople().get(i).getName().equals(lastName)) {
                System.out.println("//////////////////////////////");
                System.out.println(people.getPeople().get(i).children);
                System.out.println("//////////////////////////////");
                return;
            }
        }
        System.out.println("no such person");
    }
}
