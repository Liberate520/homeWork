import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        List<Person> listOfPersons = new LinkedList<>();
        List<FamilyCell> listAllFamilies = new LinkedList<>();
        Map<String, FamilyCell> familyEnvironment = new HashMap<>();
        // String nameForSearch = "";


        String str = "";
        Scanner scanner = new Scanner(System.in, "UTF-8");

        while (!str.equals("0")){
            System.out.println("выберите пункт меню \n");
            System.out.println("1 - загрузить заранее подготовленый тестовый список имен");
            System.out.println("2 - продолжить с сохраненного списка");
            System.out.println("3 - ввести данные о новом человеке");
            System.out.println("4 - ввести данные об окруженнии человека");
            System.out.println("5 - вывести всех всех людей в списке");
            System.out.println("6 - введите имя человека для поиска");
            System.out.println("7 - сохранить список");
            System.out.println("0 - завершить работу");


//            if (scanner.hasNext()){
                str = scanner.next();
//            }
//            scanner.close();

            switch (str){
                case ("1"):{
                    listOfPersons = fillAllPersons ();
                    listAllFamilies = fillAllFamilies (listOfPersons);
                    // создаем словарь соответствия семьи к человеку. Имя человека  - его семья
                    familyEnvironment = fillEnvironment(listOfPersons, listAllFamilies);

                    System.out.println("база тестовых данных загружена \n");
                    break;
                }
                case ("2"):{
//                    читаем ранее записаные списки людей и их связей
                    Repo repo1 = new Repo();
                    listOfPersons = (List<Person>) repo1.read("person.out");
                    Repo repo2 = new Repo();
                    listAllFamilies = (List<FamilyCell>) repo2.read("familycells.out");

                    familyEnvironment = fillEnvironment(listOfPersons, listAllFamilies);
                    System.out.println("база данных загружена \n");
                    break;
                    }
                case ("3"): {
//                    3 - ввести данные о новом человеке"
                    break;
                }
                case ("4"): {
//                    4 - ввести данные об окруженнии человека"
                    break;
                }
                case ("5"): {
                    // выводим список всех людей в базе данных
                    for (int i = 0; i<listOfPersons.size(); i++){
                        System.out.println(listOfPersons.get(i));
                    }
                    break;
                }
                case ("6"): {
                    // запрос имени для поиска в базе
                    SearchPerson(familyEnvironment);
                    break;
                }
                case ("7"):{
//                    записываем списки людей и их связей
                    Repo repo1 = new Repo();
                    repo1.save((Serializable) listOfPersons, "person.out");
                    Repo repo2 = new Repo();
                    repo2.save((Serializable) listAllFamilies, "familycells.out");

                    break;
                }
                default:{
                    if (!str.equals("0")) {
                        System.out.println("неверный ключ");
                    }
                    break;
                }
            }
        }
        scanner.close();


        System.out.println("До новых встреч! \n");
    }

    public static List <Person> fillAllPersons () {
        List<Person> listOfPersons = new LinkedList<>();
        listOfPersons.add(new Person("Ivan1","male", 1000, 1030));
        listOfPersons.add(new Person("Ivan2","male", 1021, 1040));
        listOfPersons.add(new Person("Vasiliy1","male", 1032, 1055));
        listOfPersons.add(new Person("Fedor1","male", 1034, 1060));
        listOfPersons.add(new Person("Sofia1","female", 1037, 1069));

        return listOfPersons;
    }

    public static List <FamilyCell> fillAllFamilies (List<Person> listOfPersons) {
        List<FamilyCell> listAllFamilies = new LinkedList<>();
        listAllFamilies.add(new FamilyCell(null, null, listOfPersons.get(0),(List.of(listOfPersons.get(1)))));
        listAllFamilies.add(new FamilyCell(listOfPersons.get(0),null,listOfPersons.get(1),(List.of(listOfPersons.get(2),listOfPersons.get(3),listOfPersons.get(4)))));
        listAllFamilies.add(new FamilyCell(listOfPersons.get(1),null,listOfPersons.get(2),(null)));
        listAllFamilies.add(new FamilyCell(listOfPersons.get(1),null,listOfPersons.get(3),(null)));
        listAllFamilies.add(new FamilyCell(listOfPersons.get(1),null,listOfPersons.get(4),(null)));

        return listAllFamilies;
    }

    public static void SearchPerson(Map<String, FamilyCell> familyTree){
        String nameForSearch="";
        System.out.println("введите имя человека для поиска \n");
        Scanner scanner1 = new Scanner(System.in, "UTF-8");
//        if (scanner1.hasNext()){
            nameForSearch = scanner1.next();
//        }
//        scanner1.close();
       if (familyTree.get(nameForSearch)==null){
           System.out.println("человек с таким именем не найден");
       }
       else{
           System.out.println(familyTree.get(nameForSearch));
       }
    }
    public static Map<String, FamilyCell> fillEnvironment(List<Person> listOfPersons, List<FamilyCell> listAllFamilies){
        Map<String, FamilyCell> familyEnvironment = new HashMap<>();
        for (int i=0; i<listOfPersons.size(); i++){
            familyEnvironment.put(listOfPersons.get(i).getName(), listAllFamilies.get(i));
        }
        return familyEnvironment;
    }
}
