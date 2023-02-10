import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Person> listOfPersons = new LinkedList<>();
        listOfPersons = fillAllPersons ();

        List<Family> listAllFamilies = new LinkedList<>();
        listAllFamilies = fillAllFamilies (listOfPersons);
// создаем словарь соответствия семьи к человеку. Имя человека  - его семья
        Map<String, Family> familyTree = new HashMap<>();
        for (int i=0; i<listOfPersons.size(); i++){
            familyTree.put(listOfPersons.get(i).getName(), listAllFamilies.get(i));
        }

//        System.out.println(familyTree);
        // выводим список всех людей в базе данных

        for (int i = 0; i<listOfPersons.size(); i++){
            System.out.println(listOfPersons.get(i));
        }
        // запрос имени для поиска в базе
        System.out.println("введите имя человека для поиска \n");
        Scanner scanner = new Scanner(System.in);
        String nameForSearch = scanner.nextLine();
//        System.out.println(nameForSearch);
        scanner.close();

        Family currentFamily = familyTree.get(nameForSearch);
        System.out.println(currentFamily);

    }

    public static List <Person> fillAllPersons () {
        List<Person> listOfPersons = new LinkedList<>();
        listOfPersons.add(new Person("Ivan 1","male", 1000, 1030));
        listOfPersons.add(new Person("Ivan 2","male", 1021, 1040));
        listOfPersons.add(new Person("Vasiliy 1","male", 1032, 1055));
        listOfPersons.add(new Person("Fedor 1","male", 1034, 1060));
        listOfPersons.add(new Person("Sofia 1","female", 1037, 1069));

        return listOfPersons;
    }

    public static List <Family> fillAllFamilies (List<Person> listOfPersons) {
        List<Family> listAllFamilies = new LinkedList<>();
        listAllFamilies.add(new Family(new Person(), new Person(), listOfPersons.get(0),(List.of(listOfPersons.get(1)))));
        listAllFamilies.add(new Family(listOfPersons.get(0),new Person(),listOfPersons.get(1),(List.of(listOfPersons.get(2),listOfPersons.get(3),listOfPersons.get(4)))));
        listAllFamilies.add(new Family(listOfPersons.get(1),new Person(),listOfPersons.get(2),(List.of(new Person()))));
        listAllFamilies.add(new Family(listOfPersons.get(1),new Person(),listOfPersons.get(3),(List.of(new Person()))));
        listAllFamilies.add(new Family(listOfPersons.get(1),new Person(),listOfPersons.get(4),(List.of(new Person()))));

        return listAllFamilies;
    }
}
