package ui;

import model.TreeFamily.TreeFamily;
import model.human.Human;
import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;//куда отправлять информацию
    private Scanner scannerName;// для работы с пользователем
    private Scanner scannerMenu;
    private Scanner scannerFamily;
    private  Human human;// для вывода данных о человеке в консоль
    private TreeFamily tree;

    public Console() {
        scannerMenu = new Scanner(System.in);
        scannerName = new Scanner(System.in);
        scannerFamily = new Scanner(System.in);
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void start() {
        Boolean bul = true;
         while (bul) {
            int num = scanMenu();
            switch (num) {
                case 1:{
                    String name = scanName();
                    String family = scanFamily();
                    Human human = new Human(family, name);
                    presenter.addHuman(human);
                    print(human);}
                case 2: {
                    printTree(presenter.getTree());
                }
                case 3:{
                    bul= false;
                }
            }

        }
//        scannerMenu.close();
//        scannerName.close();
//        scannerFamily.close();



    }

    private int scanMenu() {
        System.out.println("Нажмите 1, чтобы добавить человека в дерево\n" +
                "или 2, чтобы просмотреть генеалогическое древо\n"+
                "3  - чтобы выйти");
        return scannerMenu.nextInt();



    }

    private String scanName() {
        System.out.println("Введите имя: ");
        return scannerName.nextLine();
    }

    private String scanFamily() {
        System.out.println("Введите фамилию: ");
        return scannerFamily.nextLine();
    }

    @Override
    public void print(Human human) {
        System.out.println(human);
    }

    @Override
    public void printTree(TreeFamily tree) {
        System.out.println(tree.getInfo());
    }
}
