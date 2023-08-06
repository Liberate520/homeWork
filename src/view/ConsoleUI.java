package src.view;

import src.model.Gender;
import src.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;  //   DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.IOException;
public class ConsoleUI  implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
//    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (menu.work()){
            printMenu();
            execute();
        }
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public String scan() {
        scanner = new Scanner(System.in, "Cp866");
        return scanner.nextLine();
    }

    public void finish() {
        System.out.println("Приятно было пообщаться...");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumansInfo() {
        presenter.getHumansInfo();
    }

    public void addHuman() {
        Gender gSex = Gender.Man;
        DateTimeFormatter formatterDt;
        formatterDt = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        System.out.print("Введите имя человека :");
        String name = scanner.nextLine();
        System.out.print("Введите пол :");
        String aG = "м",   aGendeereStr = scanner.nextLine();
        if (!aGendeereStr.toLowerCase().contains("м")) {
            gSex = Gender.Femail;  // aG = "ж";
        }
        boolean dt_good = false; LocalDate lt = LocalDate.now();
        while (!dt_good){
            System.out.print("Введите день рождения :");
            String aBD = scanner.nextLine();
            lt = LocalDate.parse(aBD, formatterDt);

            try {  // https://www.programcreek.com/java-api-examples/?api=java.time.format.DateTimeParseException
                lt = LocalDate.parse(aBD, formatterDt);  dt_good = true;
            } catch (DateTimeParseException e) {
//                 java.time.format.DateTimeParseException
                System.out.print(e.getMessage());
                dt_good = false; lt = LocalDate.now();

//                e.printStackTrace();
//                throw MessageException.of("The date '" + aBD + "' does not respect format '" , e);
            }
        }
        presenter.addHuman(name, gSex, lt);
    }

    public void AddChild(){
//        presenter.addChild(name, age);
    }

    public void humanSearch() {
        System.out.print("Введите имя человека для поиска-> ");
        String name = scan();
        presenter.humanSearch(name);
    }

    public void LoadHumansFromFile() {
        System.out.print("Введите имя Файла-> ");
        String fileName = scan();
        presenter.LoadHumansFromFile(fileName);
    }

    public void AppendHumansFromFile(){
        System.out.print("Введите имя Файла-> ");
        String fileName = scan();
        presenter.LoadHumansFromFile(fileName);
    }

    public void SaveHumansToFile() {  // throws IOException, ClassNotFoundException
        System.out.print("Введите имя Файла-> ");
        String fileName = scan();
        presenter.SaveHumansToFile(fileName);
    }

    private void hello(){
        System.out.println("\t Human Tree \nДоброго времени суток!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
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

    private void printMenu(){
        System.out.println(menu.menu());
        System.out.print("Выберите пункт Меню -> ");
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }



}
