package Package.Menu;

import Package.Tree.Person;
import Package.Tree.Tree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {

    public Menu(){}
    public void showMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("Добро пожаловать в программу по созданию генеалогического древа!\n");
        sb.append("Вам доступны следующие действия:\n");
        sb.append("1 - показать генеалогическое древо\n");
        sb.append("2 - добавление нового человека\n");
        sb.append("3 - изменение существующего объекта\n");
        sb.append("4 - удаление существующего объекта\n");
        sb.append("0 - выход из программы\n");
        System.out.println(sb.toString());
    }

    public void choose(String msg, Tree obj) throws ParseException {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if (choice == 1){
            System.out.println(obj.showFamily());
            choose(msg, obj);
        }
        if (choice == 2){
            Tree<Person> newPerson = new Tree<>();
            System.out.print("Введите имя: ");
            String name = sc.next();
            System.out.print("Введите фамилию: ");
            String surname = sc.next();
            System.out.print("Введите дату рождения в формате yyyy-mm-dd: ");
            LocalDate date = null;
            try {
                date.parse(sc.next());
            } finally {
                date = null;
            }
            System.out.print("Введите дату смерти в формате yyyy-mm-dd: ");
            LocalDate date2 = null;
            try {
                date2.parse(sc.next());
            } finally {
                date2 = null;
            }
            System.out.print("Введите id отца: ");
            Integer fatherId = sc.nextInt();
            System.out.print("Введите id матери: ");
            Integer motherId = sc.nextInt();
            obj.addMember(new Person(10, name, surname, date, date2, obj.setById(fatherId), obj.setById(motherId)));
            choose(msg, obj);
        }
        if (choice == 0) System.out.println("Работа с программой завершена!");
    }

}
