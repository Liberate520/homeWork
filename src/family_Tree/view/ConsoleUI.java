package family_Tree.view;

import family_Tree.model.human.Gender;
import family_Tree.model.writer.Writable;
import family_Tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private String error = "Вы ввели некорректное значение. Введите целое число";
    private String errorId = "Человека с таким ID нет в древе";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello() {
        answer("Добро пожаловать в меню программы 'Семейное древо'");
    }

    public void finish() {
        answer("Сеанс завершен. До свидания!");
        work = false;
        scanner.close();
    }

    private void printMenu(){
        answer(menu.getMenu());
    }

    public void printTree(){
        presenter.print();
    }

    public void generateTree(){
        presenter.generateTree();
    }

    public void addHuman(){
        answer("Введите имя : ");
        String name = scanner.nextLine();
        answer("Введите дату рождения");
        LocalDate dateOfBirth = getDate();
        answer("Выберите пол : 1. Мужской, 2. Женский : ");
        String answer = scanner.nextLine();
        Gender gender = getGender(answer);

        presenter.addHuman(name,dateOfBirth,gender);
    }

    public void addChild(){
        answer("Введите ID родителя");
        int parentId = checkId(scanner.nextLine());
        if (parentId>=0) {
            answer("Введите ID ребёнка");
            int childId = checkId(scanner.nextLine());
            if (childId >= 0) {
                presenter.addChild(parentId, childId);
            } else {
                answer(errorId);
            }
        }else{
                answer(errorId);
        }
    }

    public void addParent(){
        answer("Введите ID человека, которому требуется добавить родителя");
        int humanId = checkId(scanner.nextLine());
        if (humanId>=0){
            answer("Введите ID родителя");
            int parentId = checkId(scanner.nextLine());
            if (parentId>=0){
                presenter.addParent(humanId,parentId);
            } else {
                answer(errorId);
            }
        }
    }

    public void setDeathDate(){
        answer("Введите ID человека, которому требуется добавить дату смерти");
        int humanId = checkId(scanner.nextLine());
        if(humanId>=0){
            answer("Введите дату смерти");
            LocalDate dateOfDeath = getDate();
            presenter.setDeathDate(humanId, dateOfDeath);
        }
    }

    public Gender getGender(String answer) {
        Gender gender = null;
        if (answer.equals("1")){
            gender = Gender.Male;
        }
        if (answer.equals("2")){
            gender = Gender.Female;
        }
        return gender;
    }

    public LocalDate getDate(){
        boolean flag = true;
        LocalDate date = null;
        while (flag) {
            answer("Формат ввода ГГГГ-ММ-ДД (пример: 2000-05-25)");
            flag = false;
            try {
                date = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                answer("Вы ввели неверную дату повторите ввод");
                flag = true;
            }
        }
        return date;
    }
    private void execute(){
        String input = scanner.nextLine();
        if (checkIfInt(input)){
            int numCommand = Integer.parseInt(input);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkIfInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private int checkId(String id){
        if (checkIfInt(id)) {
            int intId = Integer.parseInt(id);
            if (findById(intId)) {
                return intId;
            }
        }
        return -1;
    }

    private boolean findById(int id){
        return presenter.findById(id);
    }

    private void inputError(){
        System.out.println(error);
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortById(){
        presenter.sortById();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void load(){
        presenter.load();
    }

    public void save(){
        presenter.save();
    }

    public void setWritable(Writable writable) {
        presenter.setWritable(writable);
    }

    @Override
    public void answer(String text) {
        System.out.println(text);
    }
}
