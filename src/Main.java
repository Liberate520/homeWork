import tree.FamilyTree;
import Files.FileHandler;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while(true){
           user_choise();
        }
    }
    public static void user_choise() throws IOException, ClassNotFoundException{
        String menuPoints[] = new String[]{"1. Сохранить древо в файл", "2. Прочитать древо из файла", "3. Отобразить информацию о членах семьи"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню: ");
        for(int step = 0; step<menuPoints.length; step++){
            System.out.println(menuPoints[step]);
        }
        System.out.println("Введите число для выбора пункта меню: ");
        try{
            int point = Integer.parseInt(scanner.nextLine());
            switch(point){
                case 1:
                    System.out.println("Сохраняю семью из примера в файл");
                    FamilyTree exampleFamilyTree = FamilyTree.exampleFamylyTree();
                    FileHandler.save(exampleFamilyTree);
                    break;
                case 2:
                    System.out.println("Считываю семью из файла");
                    try {
                        exampleFamilyTree = FileHandler.load();
                        System.out.println(exampleFamilyTree.allMembersMaxInfo());   
                    } catch (Exception e) {
                        System.out.println("Не удалось прочитать файл.");
                    }
                    break;
                case 3:
                    family_viewer();
                    break;
                default:
                    System.out.println("Такого пункта нет в меню");
                    break;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Пожалуйста, введите число.");
        }
    }
    public static void family_viewer(){
        FamilyTree exampleTree = FamilyTree.exampleFamylyTree();
        System.out.println("Пожалуйста, выберите способ сортировки членов семьи, для вывода их на экран в выбранном порядке: ");
        String menuPoints[] = new String[]{"1. Сортировать по ID", "2. Сортировать по возрасту", "3. Сортировать по имени", "4. Сортировать по фамилии"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите пункт меню: ");
        for(int step = 0; step<menuPoints.length; step++){
            System.out.println(menuPoints[step]);
        }
        System.out.println("Введите число для выбора пункта меню: ");
        try{
            int point = Integer.parseInt(scanner.nextLine());
            switch(point){
                case 1:
                    System.out.println("Члены семьи отсортированные по ID: ");
                    exampleTree.sortById();
                    System.out.println(exampleTree.allMembersMaxInfo());
                    break;
                case 2:
                    System.out.println("Члены семьи отсортированные по возрасту: ");
                    exampleTree.sortByAge();
                    System.out.println(exampleTree.allMembersMaxInfo());
                    break;
                case 3:
                    System.out.println("Члены семьи отсортированные по имени: ");
                    exampleTree.sortByName();
                    System.out.println(exampleTree.allMembersMaxInfo());
                    break;
                case 4:
                    System.out.println("Члены семьи отсортированные по фамилии: ");
                    exampleTree.sortByLastName();
                    System.out.println(exampleTree.allMembersMaxInfo());
                    break;
                default:
                    System.out.println("Такого пункта нет в меню");
                    break;
            }
        }
        catch (NumberFormatException ex) {
            System.out.println("Пожалуйста, введите число.");
        }
    }
}