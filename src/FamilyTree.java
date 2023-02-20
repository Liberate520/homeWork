import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class FamilyTree {
    private List<Person> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<Person> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Person Person) {
        if (Person == null) {

            return false;
        }
        if (!humanList.contains(Person)){
            humanList.add(Person);
            if (Person.getFather() != null){
                Person.getFather().addChild(Person);
            }
            if (Person.getMother() != null){
                Person.getMother().addChild(Person);
            }
            return true;
        }
        return false;
    }
    public Person getByName(String name) {
        for (Person Person: humanList) {
            if (Person.getName().equals(name)){
                return Person;
            }
        }
        return null;
    }

    public Person getInfo() throws IOException, ClassNotFoundException {
        while (true) {
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Поиск(1), Весь список(2), Сохранить(3), Востановить(4), Выход(5): ");
            int choice1 = iScanner.nextInt();
            if (choice1 == 1) {
                Scanner Scanner = new Scanner(System.in);
                System.out.println("Поиск по династии: ");
                String search = Scanner.nextLine();
                Predicate<Person> laptopOs = n -> n.getName().equals(search);
                humanList.stream()
                        .filter(laptopOs)
                        .forEach(System.out::println);
            }else if (choice1 == 2) {
                System.out.println();
                System.out.println("Генеалогическое древо Романовых: ");

                for (Person p : humanList) {
                    System.out.println(p);
                }
            }else if (choice1 == 3) {
                Serializable save = new Save();
                save.voice(humanList);

            }else if (choice1 == 4) {
                Serializable restore = new Load();
                restore.voice(humanList);
            }else if (choice1 == 5) {
                return null;
        }
        }
    }

}