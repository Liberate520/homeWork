
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private FamilyTree familyTree1;    

    public Console(FamilyTree familyTree1) {
        scanner = new Scanner(System.in);
        this.familyTree1=familyTree1;
    }   

    public void commands() {

        System.out.println("Введите команду: '1' - распечатать дерево, '2' - сортировать дерево");
        String comm = scanner.nextLine();
        if (comm.equals("1")) {            
            System.out.println(familyTree1.getAllHumanToString());
                      
        }
        if (comm.equals("2")) {
            familyTree1.sortByName();
            System.out.println("Сортировка");
            System.out.println(familyTree1.getAllHumanToString());
    }
}
  
    // не получается записать строку human и в gender???
    // @Override
    // public void commands() {
    // System.out.println("Введите команду: '1' - добавить члена семьи, '2' -
    // распечатать дерево");
    // String comm = scanner.nextLine();;
    // if (comm.equals("1")){
    // scanner = new Scanner(System.in);
    // System.out.println("Введите имя");
    // String name = scanner.nextLine();
    // System.out.println("Введите пол (male female)");
    // String gender = scanner.nextLine();
    // System.out.println("Введите год рождения");
    // Integer year = scanner.nextInt();
    // System.out.println("Введите имя отца");
    // String father = scanner.nextLine();
    // System.out.println("Введите имя матери");
    // String mother = scanner.nextLine();
    // service.addIndivid(name, gender, year, father, mother);

    // }
    // if (comm=="2"){
    // familyTree.getAllHumanToString();
    // }

    // }

}

