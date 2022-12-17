import Model.Role;

import java.util.Scanner;

public class UserInterface {
    public  Research research;

    public UserInterface(Research research) {
        this.research = research;
    }

    public void Run() throws ClassNotFoundException {
        System.out.println("Commands: 1 - find person, 2 - find mother, 3 - find father, 4 - find children, 5 - print all");
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        scanner.nextLine();
        switch (command) {
            case 1 -> {
                String name = getName(scanner);
                Role person = research.findPerson(name);
                System.out.println(person + ": " + person.getAge() + "age");
            }
            case 2 -> {
                String name = getName(scanner);
                research.whoYourMother(name);
            }
            case 3 -> {
                String name = getName(scanner);
                research.whoYourFather(name);
            }
            case 4 -> {
                String name = getName(scanner);
                research.whoYourChildren(name);
            }
            case 5 -> {
                research.printAllPeople();
            }
        }
    }

    private String getName(Scanner scanner) throws ClassNotFoundException {
        System.out.println("Input firstname and lastname");
        String name = scanner.nextLine();

        return name;
    }
}
