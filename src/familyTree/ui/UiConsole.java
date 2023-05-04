package familyTree.ui;

import familyTree.presenter.Presenter;

import java.util.Scanner;

public class UiConsole implements View {

    private Menu menu;
    private boolean work;
    private Presenter presenter;
    private Scanner scan;
    private static final String INPUT_ERROR = "Ошибка во входных данных";

    public UiConsole() {
        scan = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void show(String text) {
        System.out.println(text);
    }

    public void addToTree(){
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя: ");
        String fullName = scan.nextLine();
        System.out.print("Введите пол (\"м\" или \"ж\"): ");
        String gender = scan.nextLine();
        System.out.print("Введите дату рождения(вида ддммгггг): ");
        String dateOfBirth = scan.nextLine();
        System.out.print("Введите дату смерти или ничего не вводите: ");
        String dateOfDeath = scan.nextLine();
        System.out.print("Введите полное имя матери: ");
        String mother = scan.nextLine();
        System.out.print("Введите полное имя отца: ");
        String father = scan.nextLine();
        System.out.print("Введите имя супрга(и) или ничего не вводите: ");
        String spouse = scan.nextLine();
        System.out.print("Введите имена детей или ничего не вводите: ");
        String children = scan.nextLine();
        this.presenter.addToTree(treeName, fullName, gender,
                dateOfBirth, dateOfDeath,
                mother, father, spouse, children);
    }

    @Override
    public void getAllInfo() {
        this.presenter.getAllInfo();
    }

    @Override
    public void getInfoConcreteTree() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        this.presenter.getInfoConcreteTree(treeName);
    }

    @Override
    public void getInfoHumanFromTree() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoHumanFromTree(treeName, fullName);
    }

    @Override
    public void getInfoGender() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoGender(treeName, fullName);
    }

    @Override
    public void getInfoParents() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoParents(treeName, fullName);
    }

    @Override
    public void getInfoDateOfBirth() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoDateOfBirth(treeName, fullName);
    }

    @Override
    public void getInfoDateOfDeath() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoDateOfDeath(treeName, fullName);
    }

    @Override
    public void getInfoAge() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoAge(treeName, fullName);
    }

    @Override
    public void getInfoSpouse() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoSpouse(treeName, fullName);
    }

    @Override
    public void getInfoChildren() {
        System.out.print("Введите название древа: ");
        String treeName = scan.nextLine();
        System.out.print("Введите полное имя человека: ");
        String fullName = scan.nextLine();
        this.presenter.getInfoChildren(treeName, fullName);
    }



    private void initGreeting(){
        System.out.println("Начинаем работу с древом");
    }

    private void showMenu(){
        System.out.println(menu.show());
    }

    private void wrongInput(){
        System.out.println(INPUT_ERROR);
    }

    private boolean checkingTextForInt(String text){
        if (text.matches("[0-9]+")) return true;
        else {
            wrongInput();
            return false;
        }
    }

    private boolean checkingCommandsNum(int commandNum){
        if (commandNum <= menu.menuSize()) return true;
        else {
            wrongInput();
            return false;
        }
    }

    private void execute(){
        String text = scan.nextLine();
        if (checkingTextForInt(text)) {
            int commandNum = Integer.parseInt(text);
            if (checkingCommandsNum(commandNum))
                menu.execute(commandNum);
        }
    }

    @Override
    public void start() {
        initGreeting();
        while (work){
            showMenu();
            execute();
        }
    }

    @Override
    public void finish() {
        System.out.println("Работа закончена");
        work = false;
    }


}
