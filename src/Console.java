import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    // private FamilyTree <Human> familyTree1;
    // private Human human;
    private Menu menu;
    private boolean work;

    public Console() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("что-то пошло не так");
            }
        }
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    private void hello() {
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public void finish() {
        work = false;
    }

    // public Gender detectGender(String answer){
    // Gender gender;
    // if(answer.contains("w")){
    // gender = Gender.female;
    // } else {
    // gender = Gender.male;
    // }
    // return gender;
    // }

    // public String enterGender(){
    //     String gender = "";
    //     boolean validGender = false;
    //     while (!validGender) {
    //         System.out.println("Enter gender (m/f): ");
    //         gender = scanner.nextLine();
    //         validGender = gender.equalsIgnoreCase("m") ||
    //                 gender.equalsIgnoreCase("f");
    //     }
    //     return gender;
    // }
    // private String enterBirthYear() {
    //     String birthYear = "";
    //     Date birthDate = new Date(0);
    //     boolean birtYearIsValid = false;
    //     while (!birtYearIsValid) {
    //         System.out.println("Enter birth year: ");
    //         try {
    //             birthYear = scanner.nextLine();
    //             birthDate = new SimpleDateFormat("yyyy").parse(birthYear);
    //             birtYearIsValid = true;
    //         } catch (ParseException e) {
    //             System.out.println("Wrong birth year.");
    //         }
    //     }
    //     return birthYear;
    // }


    public void add() {

        System.out.println("Enter name of a child: ");
        String name = scanner.nextLine();

System.out.println("Enter gender (male, female): ");
        String gender = scanner.nextLine();

        System.out.println("Enter birthYear: ");
        Integer birthYear = scanner.nextInt();

        System.out.println("Enter father name: ");
        String fatherName = scanner.nextLine();

        System.out.println("Enter mother name: ");
        String motherName = scanner.nextLine();


        // System.out.println("Введите Имя");
        // String name2 = scanner.nextLine();

        // System.out.println("Введите пол (male или female): ");
        // // Gender gender2 = detectGender(scanner.nextLine());
        // String gender2 = scanner.nextLine();

        // System.out.println("Введите год рождения");
        // Integer yearbirth2 = scanner.nextInt();

        // System.out.println("Введите Имя матери: ");
        // String mother2 = scanner.nextLine();

        // // Human mother = familyTree1.search(mother2);

        // System.out.println("Введите Имя отца: ");
        // String father2 = scanner.nextLine();

        // Human father = familyTree1.search(father2);// если нет имени то вернуть пусто
        // или создать Human father
        // System.out.println(father);

        presenter.add(name, gender, birthYear, fatherName, motherName);
    }
    // System.out.println(human.getInfo());

    // public void addHuman(){
    // System.out.println("Введите Имя");
    // String name2 = scanner.nextLine();
    // System.out.println("Введите пол (male или female): ");
    // String gender2 = scanner.nextLine();
    // System.out.println("Введите год рождения");
    // Integer yearbirth2 = scanner.nextInt();
    // human = new Human(name2, gender2, yearbirth2);
    // presenter.addHuman(human);

    // public void commands() {

    // System.out.println("Введите команду: '1' - распечатать дерево, '2' -
    // сортировать дерево");
    // String comm = scanner.nextLine();
    // if (comm.equals("1")) {
    // System.out.println(familyTree1.getAllHumanToString());

    // }
    // if (comm.equals("2")) {
    // familyTree1.sortByName();
    // System.out.println("Сортировка");
    // System.out.println(familyTree1.getAllHumanToString());
    // }
    // }

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
