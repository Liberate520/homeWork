
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "tree.save";
        File dir = new File(path);
        FileHandler fh = new FileHandler();
        Tree family1;
        if(dir.exists()){
            family1 = fh.loadTree(path);//"tree.save"
        }else{
            family1 = new Tree();
        }
        Scanner scan = new Scanner(System.in, "Cp866");
        System.out.print("Доступные команды: \n 1 Добавить человека \n 2 Найти человека \n 3 Вывести список всех людей \n q (выход) \n Введите команду: ");
        String cmd = scan.nextLine();
        while (!cmd.equals("q")){//////////////////////////////////////////////////////пока не введена команда выход
            switch(cmd){
                case "1"://////////////////Добавление нового человека//////////////////////
                    Person father = null;
                    Person mother = null;
                    Person addedPerson = null;
                    String secondName = "";
                    String surname = "";
                    Gender gender = null;
                    int yod = 0;
                    System.out.println("*********Добавляем нового человека в дерево*********");
                    System.out.print("Введите имя: ");
                    String name = scan.nextLine();//ввод имени
                    System.out.print("1 - Муж. 2 - Жен. Выберете пол:");
                    String selGend = scan.nextLine();
                    if(selGend.equals("1")){//выбор пола
                            gender = Gender.m;
                    }else{
                        gender = Gender.f;
                    }
                    System.out.print("Введите год рожедения: ");//ввод года рождения
                    int yob = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Добавляемый человек жив? ");
                    System.out.print("1 - да, 2 - нет. Введите № варианта: ");
                    String living = scan.nextLine();
                    if (living.equals("2")){//если не жив 
                        System.out.print("Введите год смерти: ");//уточняем дату смерти 
                        yod = scan.nextInt();
                        scan.nextLine();
                    }//А если жив, то переменная останется  = 0
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
                            if(gender.equals(Gender.m)){//если мужской пол
                                        surname = father.getSurname();
                                        secondName = father.getName() + "ович";//потом переделать
                            }
                            else{//если женский пол
                                surname = mother.getSurname();//фамилию надо будет брать от отца и трансформировать
                                secondName = father.getName() + "овна";
                            }
                            addedPerson = new Person(name, secondName, surname, father, mother, gender, yob, yod);
                            family1.addPerson(addedPerson,father,mother);//добавление человека в список 
                            break;
                        default://вариант, если родители неизвестны или неправильная команда, вводим без родителей
                            System.out.print("Введите отчество: ");
                            secondName = scan.nextLine();
                            System.out.print("Введите фамилию: ");
                            surname = scan.nextLine();
                            addedPerson = new Person(name, secondName, surname, gender, yob, yod);
                            family1.addPerson(addedPerson);
                            break;
                    }
                    System.out.println("Человек успешно добавлен!");
                    break;
                case "2":
                    System.out.println("*************Поиск человека по фамилии**************");
                    System.out.print("Введите фамилию человека: ");
                    String searchSurname = scan.nextLine();
                    // System.out.println(searchSurname);
                    System.out.println(family1.showFamily(family1.findPersons(searchSurname)));//вывод списка найденных людей
                    break;
                case "3":
                    System.out.println("**********Вывод списка всех людей в дереве**********");
                    System.out.println(family1);//вывод списка всех людей
                    break;
            }
            System.out.println("****************************************************"); 
            System.out.print("Доступные команды: \n 1 Добавить человека \n 2 Найти человека \n 3 Вывести список всех людей \n q (выход) \n Введите команду: ");
            cmd = scan.nextLine();
        }
        scan.close();
        fh.saveData(family1,"tree.save");

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