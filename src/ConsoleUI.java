import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter();
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Hello!");
        while (work) {
            System.out.println("Выберите действие:\n" +
                    "1. Добавить человека в дерево\n" +
                    "2. Получить информацию о человеке\n" +
                    "3. Показать информацию о дереве\n" +
                    "4. Открыть файл дерева\n" +
                    "5. Сохранитиь дерево\n" +
                    "6. Закончить работу\n");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addNote();
                case "2" -> getNote();
                case "3" -> getTreeInto();
                case "4" -> loadTree();
                case "5" -> saveTree();
                case "6" -> endWork();
            }
        }
    }

    public void addNote(){
        System.out.println("Фамилия:");
        String lastName = scanner.nextLine();
        System.out.println("Имя:");
        String name = scanner.nextLine();
        System.out.println("Отчество:");
        String middleName = scanner.nextLine();
        System.out.println("Пол (M/F):");
        String sex = scanner.nextLine();
        System.out.println("Дата рождения:");
        LocalDate bTime = LocalDate.parse(scanner.nextLine());

        presenter.addNote(lastName, name, middleName, sex, bTime);
    }

    public void getNote(){
        System.out.println("Выберите персону (id):");
        presenter.getSortIdList();
        String number = scanner.nextLine();
        presenter.getNote(number);
    }

    public void getTreeInto(){
        presenter.getTreeInfo();
    }

    public void loadTree(){
        presenter.loadFile();
    }

    public void saveTree(){
        presenter.saveFile();
    }

    public void endWork(){
        System.out.println("Выход совершён!");
        work = false;
    }
}
