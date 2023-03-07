
import java.util.Scanner;

public class Console implements View {
    private Scanner scanner;
    private Presenter presenter;
    private FamilyTree <Human> familyTree1;
    private Human human;
    private Menu menu;
    private boolean work;   

    
    public Console(FamilyTree<Human> familyTree1)
    // public Console() 
    {
        scanner = new Scanner(System.in);
        this.familyTree1 = familyTree1;
        // FamilyTree <Human> familyTree1 = new FamilyTree<>();        

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
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("что-то пошло не так");
            }
        }
    }

        private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }

    private void hello() {
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }

    public void finish(){
        work = false;
    }


    public Gender detectGender(String answer){
        Gender gender;
        if(answer.contains("w")){
            gender = Gender.female;
        } else {
            gender = Gender.male;
        }
        return gender;
    }



    public void add(){
        System.out.println("Введите Имя");
        String name2 = scanner.nextLine();

        System.out.println("Введите пол (male или female): ");
        Gender gender2 = detectGender(scanner.nextLine());


        System.out.println("Введите год рождения");
        Integer yearbirth2 = scanner.nextInt();

        System.out.println("Введите Имя матери: ");
        String mother2 = scanner.nextLine();

        // Human mother = familyTree1.search(mother2);


        System.out.println("Введите Имя отца: ");
        String father2 = scanner.nextLine();   

        // Human father = familyTree1.search(father2);// если нет имени то вернуть пусто или создать Human father
        // System.out.println(father);

                          
        presenter.add(new Human(name2, gender2, yearbirth2, father2, mother2)); 
        System.out.println(human.getInfo());
       
    }












    // public void addHuman(){
    //     System.out.println("Введите Имя");
    //     String name2 = scanner.nextLine();
    //     System.out.println("Введите пол (male или female): ");
    //     String gender2 = scanner.nextLine();
    //     System.out.println("Введите год рождения");
    //     Integer yearbirth2 = scanner.nextInt();
    //     human = new Human(name2, gender2, yearbirth2);
    //     presenter.addHuman(human);









    
//     public void commands() {

//         System.out.println("Введите команду: '1' - распечатать дерево, '2' - сортировать дерево");
//         String comm = scanner.nextLine();
//         if (comm.equals("1")) {            
//             System.out.println(familyTree1.getAllHumanToString());
                      
//         }
//         if (comm.equals("2")) {
//             familyTree1.sortByName();
//             System.out.println("Сортировка");
//             System.out.println(familyTree1.getAllHumanToString());
//     }
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

