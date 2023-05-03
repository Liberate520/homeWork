package Package.View;

import Package.View.Commands.*;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Commander> list;

    public Menu(Console console){
        this.list = new ArrayList<>();
        list.add(new ShowTree(console));
        list.add(new AddPerson(console));
        list.add(new DeletePerson(console));
        list.add(new FinishProgram(console));
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(i+1 + ". " + list.get(i).getDescription() + "\n");
        }
        return sb.toString();
    }

    public int getSize(){
        return list.size();
    }

    public void execute(int choice){
        list.get(choice - 1).execute();
    }
//    public void showMenu(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("Добро пожаловать в программу по созданию генеалогического древа!\n");
//        sb.append("Вам доступны следующие действия:\n");
//        sb.append("1 - показать генеалогическое древо\n");
//        sb.append("2 - добавление нового человека\n");
//        sb.append("3 - изменение существующего объекта\n");
//        sb.append("4 - удаление существующего объекта\n");
//        sb.append("0 - выход из программы\n");
//        System.out.println(sb.toString());
//    }
//
//    public void choose(String msg, E obj, Service struct) throws ParseException {
//        System.out.print(msg);
//        Scanner sc = new Scanner(System.in);
//        int choice = sc.nextInt();
//        if (choice == 1){
//            System.out.println(obj.showFamily());
//            StringBuilder sb = new StringBuilder();
//            sb.append("Доступны следующие виды сортировки:\n");
//            sb.append("1 - по имени\n");
//            sb.append("2 - по фамилии\n");
//            sb.append("3 - по дате рождения\n");
//            sb.append("0 - вернуться обратно в меню\n");
//            sb.append("Ваш выбор: ");
//            System.out.println(sb);
//
//            Scanner scan = new Scanner(System.in);
//            int num = scan.nextInt();
//            while (num != 0) {
//                if (num == 1) {
//                    obj.sortByName();
//                    System.out.println(obj.showFamily());
//                    System.out.println(sb);
//                    num = scan.nextInt();
//                }
//                if (num == 2) {
//                    obj.sortBySurname();
//                    System.out.println(obj.showFamily());
//                    System.out.println(sb);
//                    num = scan.nextInt();
//                }
//                if (num == 3) {
//                    obj.sortByBirthdate();
//                    System.out.println(obj.showFamily());
//                    System.out.println(sb);
//                    num = scan.nextInt();
//                }
//                if (num == 0) {
//                    showMenu();
//                    choose(msg, obj, struct);
//                }
//            }
//        }
//        if (choice == 2){
//            Tree<Person> newPerson = new Tree<>();
//            System.out.print("Введите имя: ");
//            String name = sc.next();
//            System.out.print("Введите фамилию: ");
//            String surname = sc.next();
//            System.out.print("Введите дату рождения в формате yyyy-mm-dd: ");
//            LocalDate date = LocalDate.parse(sc.next());
//            System.out.print("Введите дату смерти в формате yyyy-mm-dd: ");
//            LocalDate date2 = LocalDate.parse(sc.next());
//            System.out.print("Введите id отца: ");
//            Integer fatherId = Integer.parseInt(sc.next());
//            System.out.print("Введите id матери: ");
//            Integer motherId = Integer.parseInt(sc.next());
//            struct.addMember(name, surname, date, date2, obj.setById(fatherId), obj.setById(motherId));
//            Person member = (Person) obj.getFamily().get(obj.getFamily().size() - 1);
//            System.out.println(member.showInfo());
//
//            showMenu();
//            choose(msg, obj, struct);
//        }
//        if (choice == 0) System.out.println("Работа с программой завершена!");
//    }

}
