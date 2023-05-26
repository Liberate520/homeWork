package homeWork.tree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        controller();

    }

    public static void presentationPeople(ArrayList<Human> people) {
        for(Human man : people) {
            System.out.println(man);
        }
    }

    public static void presentationParents(ArrayList<Parent> parents) {
        System.out.println("Родители:");
        for (Parent p : parents) {
            if(p.getChildren().size() > 0) {
                System.out.println(p.toString().replace("[", "| Дети: ").replace("]", ""));
            }
            else {
                continue;
            }
        }
    }


    public static void presentationChildren(ArrayList<Child> children) {
        System.out.println("Дети:");
        for (Child child : children) {
            System.out.println(child.getName() +" | Родитель-"+ child.getParents().toString().split(" ")[0].replace("[", ""));
        }
    }


    public static void aboutHuman(Human human) {
        for (Parent p : FamilyTree.getParents()){
            if(human.getName().equalsIgnoreCase(p.getName())){
                System.out.println("Дети: ");
                System.out.println(p.getChildren());
            }
        }
        for (Child ch: FamilyTree.getChildren()){
            if (human.getName().equalsIgnoreCase(ch.getName())){
                System.out.println("Родители:");
                System.out.println(ch.getParents());
            }
        }
    }

    public static ArrayList findBrothers(Human human) {
        ArrayList<String> brothers = new ArrayList<>();

        Child currentChild = null;
        for (Child child : FamilyTree.getChildren()) {
            if (child.getName().equalsIgnoreCase(human.getName())) {
                currentChild = child;
                break;
            }
        }

        if (currentChild != null) {
            for (Child child : FamilyTree.getChildren()) {
                if (!child.equals(currentChild)) {
                    for (Human parent : child.getParents()) {
                        if (currentChild.getParents().get(0).getName().equals(parent.getName())) {
                            brothers.add(child.getName());
                            break;
                        }
                    }
                }
            }
        }

        return brothers;
    }




    public static void showMenu(){
        System.out.println(
                "Вот простой набор команд, с помощью которых ты сможешь быстро разобраться в нашем древе:\n" +
                        "1 - Вывод всех людей нашей базы на экран\n" +
                        "2 - Вывод всех родителей нашего древа на экран\n" +
                        "3 - Вывод всех детей нашего древа на экран\n" +
                        "4 - Поиск родителей и детей для конкретного человека\n" +
                        "6 - Выход\n"
        );
    }

    public static void controller() {
        System.out.println("Добрый день, выберите команду, чтобы обратиться к гениалогическому древу:");
        System.out.println("----------------------------------------------------------------");
        showMenu();
        System.out.println("----------------------------------------------------------------");

        Boolean flag = true;
        while (flag==true) {
            System.out.println("\nВведите команду:");
            Scanner scanner = new Scanner(System.in);
            Integer menu_item = scanner.nextInt();
            switch (menu_item) {
                case 1:
                    presentationPeople(FamilyTree.getPeople());
                    break;
                case 2:
                    presentationParents(FamilyTree.getParents());
                    break;
                case 3:
                    presentationChildren(FamilyTree.getChildren());
                    break;
                case 4:

                    for (int i = 0; i < Generation.generateFamily().size(); i++) {
                    System.out.println("id: " + i + " | " + Generation.generateFamily().get(i));
                }
                    System.out.println("Введите id человека");
                    int human_id = scanner.nextInt();
                    Human human = FamilyTree.getPeople().get(human_id);
                    aboutHuman(human);
                    break;
                case 5:
                    for (int i = 0; i < Generation.generateFamily().size(); i++) {
                        System.out.println("id: " + i + " | " + Generation.generateFamily().get(i));
                    }
                    System.out.println("Введите id человека");
                    int human_id1 = scanner.nextInt();
                    Human human1 = FamilyTree.getPeople().get(human_id1);
                    System.out.println("Братья и сестры для человека " + human1 + ": ");
                    System.out.println(findBrothers(human1));
                    break;
                case 6:
                    System.out.println("Вы уверены, что хотите покинуть наш сервис? 0-Покинуть, 1 - Остаться");
                    int answer = scanner.nextInt();
                    if (answer == 0) {
                        flag = false;
                        break;
                    }
                    else break;

            }
        }
    }

}
