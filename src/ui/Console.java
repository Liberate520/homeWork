package java_oop_homeWork.src.ui;

import java_oop_homeWork.src.presenter.Presenter;
import java_oop_homeWork.src.ui.menues.*;

import java.util.*;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean workMainMenu, workTreeMenu, workAddMenu;
    private MainMenu mainMenu;
    private TreeMenu treeMenu;
    private AddMenu addMenu;
    private SexMenu sexMenu;
    private int command, idPerson, sex;
    public Console() {
        scanner = new Scanner(System.in);
        workMainMenu = true;
        mainMenu = new MainMenu(this);
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Доброго времени суток");
        while (workMainMenu) {
            implementationMenu(mainMenu);
        }
    }

    @Override
    public void startTreeMenu() {
        workTreeMenu = true;
        treeMenu = new TreeMenu(this);
        try {
            while (workTreeMenu) {
                getFamilyName();
                implementationMenu(treeMenu);
            }
        }
        catch (NullPointerException e) {
            System.out.println("Данное семейное дерево отсутствует");
        }
    }

    @Override
    public void startAddMenu() {
        workAddMenu = true;
        addMenu = new AddMenu(this);
        System.out.println("Введите номер члена семьи, которому хотите добавить родственника");
        if (setIdPerson(inputNumber())) {
            System.out.println("Выберите кого вы хотите добавить:");
            while (workAddMenu) {
                implementationMenu(addMenu);
            }
        }
    }

    @Override
    public void implementationMenu(Menu menu) {
        System.out.println(menu.Show());
        command = inputNumber();
        if (command != -1) menu.execute(command);
    }

    public void addParent(int idPerson) {
        FullName name = inputKinsman();
        String firstName = name.getFirstName();
        String lastName = name.getLastName();
        presenter.addParent(idPerson, firstName, lastName, sex);
    }

    public void addChild(int idPerson) {
        FullName name = inputKinsman();
        String firstName = name.getFirstName();
        String lastName = name.getLastName();
        presenter.addChild(idPerson, firstName, lastName, sex);
    }

    public FullName inputKinsman() {
        FullName name = new FullName();
        System.out.println("Введите имя:");
        String firstName = scanner.next();
        System.out.println("Введите фамилию:");
        String lastName = scanner.next();

        sexMenu = new SexMenu(this);
        System.out.println("Выберите пол:");
        System.out.println(sexMenu.Show());
        command = inputNumber();
        sexMenu.execute(command);

        name.setFirstName(firstName);
        name.setLastName(lastName);
        return name;
    }

     public void createFamilyTree() {
        System.out.println("Введите название семейного дерева:");
        String family = scanner.next();
        System.out.println("Введите данные первого члена семьи:");
        FullName name = inputKinsman();
        String firstName = name.getFirstName();
        String lastName = name.getLastName();
        presenter.createFamilyTree(family, firstName, lastName, sex);
    }

    @Override
    public void selectFamilyTree() throws NullPointerException {
        System.out.println("Введите название семейного дерева:");
        String family = scanner.next();
        presenter.selectFamilyTree(family);
    }

    public void getFamilyName() throws NullPointerException {
        presenter.getNameActiveFamily();
    }

    public void getFamily() throws NullPointerException {
        presenter.getFamilyTree();
    }

    public int getIdPerson() {
        return this.idPerson;
    }

    private boolean setIdPerson(int intConsole) {
       if (presenter.isKinsman(intConsole)) {
           idPerson = intConsole;
           return true;
       }
       else System.out.println("Член семьи с таким id отсутствует");
       return false;
    }

    public int getCommand() {
        return this.command;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void finishMainMenu() {
        workMainMenu = false;
    }

    @Override
    public void finishTreeMenu() {
        workTreeMenu = false;
    }

    @Override
    public void finishAddMenu() {
        workAddMenu = false;
    }

    @Override
    public void getAllTrees() {
        presenter.getAllTrees();
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void errorSelectMenu(String error) {
        System.out.println(error);
    }

    public int inputNumber() {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        else {
            System.out.println("Введите число");
        }
        scanner.nextLine();
        return -1;
    }
}