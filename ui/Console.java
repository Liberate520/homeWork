package homeWork3.ui;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import homeWork3.Viewer;

public class Console implements View {
    private Scanner scan;
    private Viewer viewer;
    private Menu menu;
    private boolean go;

    @Override
    public void start() {
        scan = new Scanner(System.in);
        menu = new Menu(this);
        go = true;
        while (go) {
            header();
            UImenu();
            System.out.print("Выберите омер пункта из Меню выше: ");
            String command = scan.nextLine();
            if (checkInput(command)) {
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("Нужно ввести число: ");
            }
        }
    }

    private void header() {
        System.out.println();
    }

    private void UImenu() {
        System.out.println(menu.printMenu());
    }

    public void addNewHuman() {
        System.out.print("Введите имя: ");
        String name = scan();
        System.out.print("Введите пол(мужской/женский)-> ");
        String sex = scan();
        System.out.print("Введите возраст: ");
        int age = Integer.parseInt(scan());
        viewer.addNewHuman(name, sex, age);
    }

    public void printFamily() {
        viewer.printFamily();
    }

    public void searchHuman() {
        System.out.print("Введите имя для поиска: ");
        String name = scan();
        viewer.searchHuman(name);
    }

    public void saveFamily() {
        viewer.saveFamily();
    }

    public void loadFamily() {
        viewer.loadFamily();
    }

    public void sortFamilyByName() {
        viewer.sortFamilyByName();
    }

    public void sortFamilyByAge() {
        viewer.sortFamilyByAge();
    }

    public void end() {
        go = false;
        System.out.println("Спасибо, до встречи!");
    }

    @Override
    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    @Override
    public String scan() {
        scan = new Scanner(System.in, StandardCharsets.UTF_8);
        return scan.nextLine();
    }

    private boolean checkInput(String text) {
        return text.matches("[0-9]+");
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}