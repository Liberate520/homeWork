package View;

import java.util.Scanner;

import Model.GenealogicalTree.Animal;
import Presenter.Presenter;

public class Console<T extends Animal> implements View<T> {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void setPresenter(Presenter<T> presenter) {
        this.presenter = presenter;    
    }

    @Override
    public void start() {
        Scanner iScanner = new Scanner(System.in, "Cp866");
        menu = new Menu(this);
        work = true;
        while (work){
            printMenu();
            String command = iScanner.nextLine();
            if (checkInputNum(command)){
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("что-то пошло не так");
            }
        }
        iScanner.close();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    
    private boolean checkInputNum(String text){
        return text.matches("[0-9]+");
    }

    private boolean checkInputNum(int num){
        String text = Integer.toString(num);
        return checkInputNum(text);
    }

    private void printMenu() {
        System.out.println(menu.printMenu());
        System.out.println("Выберите пункт меню");
    }

    public void finish(){
        work = false;
    }
    
    public String searchSetName() {
        boolean isTrue = true;
        String res = "";
        while (isTrue){
            System.out.print("Введите имя: ");
            res = scanner.next();
            if (isCyrillic(res)) {
                isTrue = false;
            } else {
                System.out.println("\nОшибка при вводе, используйте кириллицу");
            }
        }
        return res;
    }
    
    private boolean isCyrillic(String s) {
        boolean result = false;
        for (char a : s.toCharArray()) {
            if (Character.UnicodeBlock.of(a) == Character.UnicodeBlock.CYRILLIC) {
                result = !result;
                break;
            }
        }
        return result;
    }

    // private boolean checkInputName(String text){
    //     return text.matches("[а-яёА-ЯЁ]+");
    // }
    
    public void printTree() {
        presenter.printTree();
    }

    public void searchHuman() {
        presenter.searchHuman();
    }

    public void SortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void serialization() {
        presenter.serialization();
    }

    public void deserialization() {
        presenter.deserialization();
    }

    public void addHuman() {
        presenter.addHuman();
    }

    @Override
    public int addSetSex() {
        work = true;
        int res = 1;
        while (work){
            System.out.print("Введите 1 - муж.пол или 2 - жен.пол: ");
            res = scanner.nextInt();
            if (checkInputNum(res)){
                if (res == 1 || res == 2) {
                    return res;
                }
            } else {
                System.out.println("Что-то пошло не так");
            }
        }
        return res;
    }

    @Override
    public int birthAddHuman() {
        work = true;
        int res = 0;
        while (work) {
            System.out.print("Введите год рождения: ");
            res = scanner.nextInt();
            if (checkInputNum(res)){
                return res;
            } else {
                System.out.println("Что-то пошло не так");
            }
        }
        return res;
    }
}
