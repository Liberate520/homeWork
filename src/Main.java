
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree family1 = new Tree();
        Person father = null;
        Person mother = null;
        Scanner scan = new Scanner(System.in, "Cp866");
        System.out.print("Доступные команды: \n 1 Добавить человека \n 2 Найти человека \n 3 Вывести список всех людей \n q (выход) \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            switch(cmd){
                case "1"://////////////////Добавление нового человека//////////////////////
                    System.out.print("Есть данные о родителях? 1 - Да. 2 - Нет. ->");
                    String selParInfo = scan.nextLine();
                    switch(selParInfo){
                        case "1"://родители есть
                            System.out.print("Введите фамилию отца: ");
                            String fSurname = scan.nextLine();
                            List<Person> potentialFathers = family1.findPersons(fSurname);//получение списка людей с такой же фамилией
                            System.out.println(family1.showFamily(potentialFathers));//вывод списка найденных людей
                            System.out.printf("Введите номер 1 - %d: ", potentialFathers.size());//потом продумать вариант, если ничего не найдено
                            int fIndex = scan.nextInt();
                            scan.nextLine();
                            if(fIndex > 0 && fIndex <= potentialFathers.size()){//убеждаемся, что введен действительный индекс
                                father = potentialFathers.get(fIndex-1);//выбирем человека из списка. поправка на индекс с 0, а выбирали с 1
                                //потом добавить проверку на пол. И вынести этот код в процедуру, чтобы не дублировать код!!!!!!!!!!!!!!!!!!!!!!!!
                            }
                            System.out.print("Введите фамилию матери: ");
                            String mSurname = scan.nextLine();
                            List<Person> potentialMothers = family1.findPersons(mSurname);//получение списка людей с такой же фамилией
                            System.out.println(family1.showFamily(potentialMothers));//вывод списка найденных людей
                            System.out.printf("Введите номер 1 - %d: ", potentialMothers.size());//потом продумать вариант, если ничего не найдено
                            int mIndex = scan.nextInt();
                            scan.nextLine();
                            if(mIndex > 0 && mIndex <= potentialMothers.size()){//убеждаемся, что введен действительный индекс
                                mother = potentialMothers.get(mIndex-1);//выбирем человека из списка. поправка на индекс с 0, а выбирали с 1
                                //потом добавить проверку на пол. И вынести этот код в процедуру, чтобы не дублировать код
                            }
                            family1.addPerson(father,mother);
                            break;
                        default://вариант, если родители неизвестны или неправильная команда, вводим без родителей
                            family1.addPerson();
                            break;
                    }
                    break;
                case "2":
                    System.out.print("Введите фамилию человека: ");
                    String searchSurname = scan.nextLine();
                    // System.out.println(searchSurname);
                    System.out.println(family1.showFamily(family1.findPersons(searchSurname)));//вывод списка найденных людей
                    break;
                case "3":
                    System.out.println(family1);//вывод списка всех людей
                    break;
            }
            System.out.println("****************************************************"); 
            System.out.print("Доступные команды: \n 1 Добавить человека \n 2 Найти человека \n 3 Вывести список всех людей \n q (выход) \n Введите команду: ");
            cmd = scan.nextLine();
        }
        
        // family1.addPerson();
        // family1.addPerson();
        // family1.addPerson(family1.getFamily().get(0), family1.getFamily().get(1));//добав человека с родителями  1 и 2 из списка
        // System.out.println(family1);
        // family1.getFamily().get(0).showChildren();//показать детей 1го родителя
        // System.out.println(family1.showFamily(family1.findPersons("Иванов")));//family1.findPersons("Иванов").showFamily();//в идеале так вызывать
        
        // System.out.println("1 метод");
        // System.out.println(family1);
        // System.out.println("2 метод");
        // System.out.println(family1.showFamily(family1.getFamily()));
        // System.out.println("3 метод");
        // List<Person> persons = family1.getFamily();
        // System.out.println(family1.showFamily(persons));
    }
}