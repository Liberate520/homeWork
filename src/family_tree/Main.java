package family_tree;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public FamilyTree family_tree = new FamilyTree();

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("СЕМЕЙНОЕ ДРЕВО.");
        m.startMenu();
        sc.close();
        System.out.println("СЕМЕЙНОЕ ДРЕВО. Программа закрыта.");
    }

    private void printMenu() {
        System.out.println("""

                Меню:
                1 - Вывод на экран всего древа.;
                2 - Добавить нового члена.;
                7 - Очистить древо.;
                8 - Загрузить семейное древо из файла.;
                9 - Сохранить семейное древо в файл.;
                0 - Выход;
                
                """);
    }
    private void startMenu() {
        String str = "";
        while (!str.equals("0")) {
            printMenu();
            System.out.print("Введите соответствующую цифру меню: ");
            str = sc.nextLine();
            if (str.equals("1")){
                System.out.println(family_tree);
            }
            if (str.equals("2")){
                add_human();
            }
            if (str.equals("7")){
                clearFamilyTree();
            }
            if (str.equals("8")){
                loadHumanList();
            }
            if (str.equals("9")){
                saveHumanList();
            }
        }
    }


    private Human new_human(){
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
        return human;
    }
    private void add_human(){
        Human human = new_human();
        family_tree.addToHumanList(human);
        System.out.println("Добавлен новый член.");
        System.out.println(human);

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
        System.out.println("Загрузка данных из файла. Текущий список будет удален.");
        try {
            FileInputStream fis = new FileInputStream("src/family_tree.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            family_tree = (FamilyTree) ois.readObject();
            System.out.println("Семейное древо успешно загружено.");
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }
    }

    private void saveHumanList(){
        System.out.println("Сохранение в файл.");
        try
        {
            FileOutputStream fos = new FileOutputStream("src/family_tree.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(family_tree);
            oos.close();
            fos.close();
            System.out.println("Семейное древо успешно сохранено в файл.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        } catch(IOException ioe) {
            System.out.println ("Error while writing data");
            ioe.printStackTrace();
        }

    }

    private void clearFamilyTree(){
        System.out.print("Семейное древо будет очищено.\n" +
                "Для подтверждения введите \"Yes\": ");
        String str2 = sc.nextLine();
        if (str2.equalsIgnoreCase("Yes")){
            family_tree.clearHumanList();
            System.out.println("Семейное древо успешно очищено");
        } else {
            System.out.println("Действие отменено.");
        }
    }

}
