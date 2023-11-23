package family_tree.view;

import family_tree.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
//    FamilyTree tree;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new Menu(this);
        work = true;
    }
    @Override
    public void start() {
        System.out.println("Добро пожаловать в консольное приложение.");
        while(work){
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu(){
        String itemStr = scanner.nextLine();
        int item = Integer.parseInt(itemStr);
        menu.execute(item);
    }

    private void printMenu(){
        System.out.println(menu.print());
    }

    public void exit() {
        work = false;
        System.out.println("До новых встреч.");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void addHuman(){
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол(male, female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.print("Введите дату рождения(гггг-мм-дд): ");
        LocalDate birth = LocalDate.parse(scanner.nextLine());
        System.out.print("Ввести дату смерти(y/n): ");
        LocalDate death;
        String res = scanner.nextLine();
        if (res.equals("y")){
            System.out.print("Введите дату смерти(гггг-мм-дд): ");
            death = LocalDate.parse(scanner.nextLine());
        }
        else {death = null;}
        presenter.addHuman(name,gender, birth,death,null,null);
    }

    public void printFamilyTree(){
        presenter.printFamilyTree();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

     public void loadFamilyTree() {
        presenter.loadFamilyTree();
    }

    public void saveFamilyTree() {
        presenter.saveFamilyTree();
    }

    public void addParentGlobal() {
        System.out.print("Введите id члена семьи, которому необходимо добавить родителя: ");
        Long human_id = Long.parseLong(scanner.nextLine());
        System.out.print("Введите id члена семьи, который станет родителем: ");
        Long parent_id = Long.parseLong(scanner.nextLine());
        presenter.addParentGlobal(human_id,parent_id);
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }


}
