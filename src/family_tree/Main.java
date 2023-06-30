package family_tree;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    private FamilyTree family_tree = new FamilyTree();

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("СЕМЕЙНОЕ ДРЕВО.");
        m.menu();
        sc.close();
        System.out.println("СЕМЕЙНОЕ ДРЕВО. Программа закрытв.");
    }

    private void menu() {
        String str = "";
        while (!str.equals("0")) {
            printMenu();
            System.out.println("Введите соответствующую цифру меню: ");
            str = sc.nextLine();
            if (str.equals("1")){
                System.out.println(family_tree);
            }
            if (str.equals("2")){
                add_human();
            }
            if (str.equals("8")){
                loadHumanList();
            }
            if (str.equals("9")){
                saveHumanList();
            }
        }
    }
    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Вывод на экран всего древа;
                2 - Добавить нового члена;
                8 - Загрузить семейное древо из файла;
                9 - Сохранить семейное древо в файл;
                0 - Выход;
                
                """);
    }

    private void add_human(){
        Human human = new Human(Gender.Mail);
        System.out.println("\nВвод данных нового человека.");
        System.out.print("Фамилия: ");
        human.setSurname(sc.nextLine().trim());
        System.out.print("Имя: ");
        human.setFirst_name(sc.nextLine().trim());
        System.out.print("Отчество: ");
        human.setPatronymic(sc.nextLine().trim());
        System.out.print("Дата рождения (dd.mm.yyyy): ");
        human.setDay_birth(tryLocalDate(sc.nextLine().trim()));
        System.out.print("Дата смерти (dd.mm.yyyy): ");
        human.setDay_death(tryLocalDate(sc.nextLine().trim()));
        System.out.print("Пол (по умолчанию M, для смены пола введите любой символ: ");
        human.setGender(tryGender(sc.nextLine().trim()));
        System.out.println("Добавлен новый член.");
        System.out.println(human);

        family_tree.addToHumanList(human);

    }

    private LocalDate tryLocalDate(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = "01.01.9999";
        LocalDate localDate = LocalDate.parse(date, formatter);
        try {
            localDate = LocalDate.parse(string, formatter);
        } catch (Exception ignored) {
        }
        return localDate;
    }
    private Gender tryGender(String string) {
        Gender gender = Gender.Mail;
        if (!string.isEmpty()) {
            gender = Gender.Female;
        }
        return gender;
    }

    private void loadHumanList(){
        System.out.println("Загрузка пока тестовая. Текущий список будет удален.");
        try {
            FileInputStream fis = new FileInputStream("src/family_tree.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //familyTree.clearHumanList();
            family_tree = (FamilyTree) ois.readObject();

            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    private void saveHumanList(){
        System.out.println("Сохранение в файл пока тестовое");
        try
        {
            FileOutputStream fos = new FileOutputStream("src/family_tree.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(family_tree);
            oos.close();
            fos.close();
            System.out.println("File has been written");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        } catch(IOException ioe) {
            System.out.println ("Error while writing data");
            ioe.printStackTrace();
        }

    }

}
