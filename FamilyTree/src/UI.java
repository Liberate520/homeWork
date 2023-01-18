import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI<T extends Person> {

    private FamilyTree myFamilyTree;
    private FileHandler fileHandler;
    private static Presenter presenter;
    List<Command> commandList;


    public UI(FamilyTree myFamilyTree, FileHandler fileHandler, Presenter presenter) {
        this.myFamilyTree = myFamilyTree;
        this.fileHandler = fileHandler;
        this.presenter = presenter;
        this.myFamilyTree.setWritable(fileHandler);
        this.myFamilyTree =  myFamilyTree.load();
        presenter.setMyFamilyTree(this.myFamilyTree);
        commandList = new ArrayList<>();
    }

    public static Presenter getPresenter() {
        return presenter;
    }

    public FamilyTree getMyFamilyTree() {
        return myFamilyTree;
    }

    public String getName() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        return iScanner.nextLine();
    }

    public T getPerson(FamilyTree myFamilyTree) {
        Person person = new Person();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String str = iScanner.nextLine();
        person.setName(str);
        System.out.print("Введите пол: ");
        str = iScanner.nextLine();
        person.setSex(str);
        System.out.print("Введите возраст: ");
        str = iScanner.nextLine();
        person.setAge(Integer.parseInt(str));
        return (T) person;
    }


    public void start() {
        Scanner iScanner = new Scanner(System.in);
        T person;
        commandList.add(new Command_Print(this));
        commandList.add(new Command_Add(this));
        commandList.add(new Command_SortByName(this));
        commandList.add(new Command_SortByAge(this));
        commandList.add(new Command_Exit(this));


        while (true) {
            System.out.println("Выберите действие:");
            for (int i = 0; i < commandList.size(); i++) {
                System.out.println(i + ": " + commandList.get(i).description());
            }
            System.out.print("\n");
            String str = iScanner.nextLine();
            commandList.get(Integer.parseInt(str)).execute();
        }
    }

}
