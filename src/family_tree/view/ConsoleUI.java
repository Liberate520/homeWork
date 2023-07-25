package family_tree.view;

import family_tree.model.human.Child_type;
import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import javax.sound.midi.Soundbank;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean working;
    private Menu menu;
    public ConsoleUI(){
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        presenter = new Presenter(this);
        working = true;
        menu = new Menu(this);
    }

    public void addFamilyMember(){
        System.out.println("Введите полное имя члена семьи (ФИО):");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения (в виде числа):");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfBirth = LocalDate.of(year, month, day);
        System.out.println("Введите пол (м/ж)");
        String genderLine = scanner.nextLine().toLowerCase();
        Gender gender = Gender.male;
        if (genderLine.equals("ж")) gender = Gender.female;
        presenter.addFamilyMember(name, dateOfBirth, gender);
        getFamilyInfo();
    }
    public void setParentChild(){
        getFamilyInfo();
        System.out.println("Введите id родителя: ");
        Integer id_parent = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id ребенка: ");
        Integer id_child = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите тип ребенка (Приемный/родной)");
        String child_type_line = scanner.nextLine().toLowerCase();
        System.out.println("Введите пол ребенка (м/ж)");
        String child_gender_line = scanner.nextLine().toLowerCase();
        Child_type childType = Child_type.Biological_Daughter;
        if (child_type_line.equals("приемный") && child_gender_line.equals("ж")) childType = Child_type.Foster_Daughter;
        else if (child_type_line.equals("родной") && child_gender_line.equals("м")) childType = Child_type.Biological_Son;
        else if (child_type_line.equals("приемный") && child_gender_line.equals("м")) childType = Child_type.Foster_Son;
        presenter.setParentChild(id_parent, id_child, childType);
    }
    public void setHusbandWife(){
        getFamilyInfo();
        System.out.println("Введите id мужа: ");
        Integer id_husband = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id жены: ");
        Integer id_wife = Integer.parseInt(scanner.nextLine());
        if (presenter.setHusbandWife(id_husband, id_wife)) System.out.println("Брак заключен");
        else System.out.println("Свадьба невозможна");
    }
    public void unsetHusbandWife(){
        getFamilyInfo();
        System.out.println("Введите id мужа: ");
        Integer id_husband = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id жены: ");
        Integer id_wife = Integer.parseInt(scanner.nextLine());
        if (presenter.unsetHusbandWife(id_husband, id_wife)) System.out.println("Развод произведен");
        else System.out.println("Развод невозможен");
    }
    public void showSiblings(){
        System.out.println("Введите id человека: ");
        Integer id_human = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showSiblings(id_human));
    }
    public void sortByAge(){
        presenter.sortByAge();
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void getFamilyMemberInfo(){
        System.out.println("Введите id человека: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.getFamilyMemberInfo(id));
    }
    public void setDateOfDeath(){
        System.out.println("Введите id человека: ");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите год:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц (в виде числа):");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate dateOfDeath = LocalDate.of(year, month, day);
        presenter.setDateOfDeath(id, dateOfDeath);
    }

    public void getFamilyInfo(){
        System.out.println(presenter.getFamilyInfo());
    }

    public void saveFamily(){
        System.out.println("Введите имя файла: ");
        String fileName = scanner.nextLine();
        if (!presenter.saveFamily(fileName)) {
            System.out.println("Файл не найден");
        }
        else {
            System.out.println("Файл сохранен");
            presenter.saveFamily(fileName);
        }
    }
    public void loadFamily(){
        System.out.println("Введите путь к загружаемому файлу: ");
        String fileName = scanner.nextLine();
        if (!presenter.loadFamily(fileName)) {
            System.out.println("Файл не найден");
        }
        else {
            System.out.println("Файл загружен");
            presenter.loadFamily(fileName);
        }
    }

    public void work(){
        String str_command = scanner.nextLine();
        if (str_command.matches("[0-9]+")){
            int command = Integer.parseInt(str_command);
            if (command <= menu.getSize()) menu.execute(command);
        }
    }

    @Override
    public String fileName() {
        return null;
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте");
        while (working) {
            System.out.println(menu.display());
            work();
        }
    }

    @Override
    public void finish() {
        System.out.println("До свидания");
        working = false;
    }
}
