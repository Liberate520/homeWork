//public Person(String firstName, String lastName, String birthDate,
// String deathDate, Gender gender, int idMather, int idFather)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Person personA = new Person("JEHAELIS", "Targarien", "17.05.134", "24.12.200", Gender.male);
        Person personB = new Person("ALISANNA", "Targarien", "03.11.145", "20.08.233", Gender.female);
        Person personC = new Person("BELION", "Targarien", "24.01.158", "19.06.240", Gender.male, personA.getIdFather(), personB.getIdMather());
        Person personD = new Person("ALISSA", "Targarien", "13.09.161", "18.04.248", Gender.female, personA.getIdFather(), personB.getIdMather());

        FamilyTree targariens = new FamilyTree();
        List<Person> targariensCollection = new ArrayList<>();

        targariens.addPerson(personA);
        targariens.addPerson(personB);
        targariens.addPerson(personC);
        targariens.addPerson(personD);

//        System.out.println(targariens);

//        FamilyTree descendant = new FamilyTree();
//        targariens.descendantSearch(personA);

        Collections.addAll(targariensCollection, personA, personB, personC, personD);

        System.out.println("\n1 - Output all members of the genus." +
                "\n2 - Output all decendants." +
                "\n3 - Find the great Targarien.");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        try {
            switch (option) {
                case 1:
                    System.out.println("Behold and bow before the great Targarien family!!!");
                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>");
                    System.out.println(targariens);
                    break;
                case 2:
                    FamilyTree descendant = new FamilyTree();
                    descendant.addPerson(personA);
                    descendant.addPerson(personB);
                    descendant.addPerson(personC);
                    descendant.addPerson(personD);
                    descendant.descendantSearch(personB);
//                    descendant.personParents(personC);
                    break;
//                    Не вышло =(((
//                    System.out.println("Search for descendants, enter the name of Targarien member: ");
//                    Scanner nm = new Scanner(System.in);
//                    FamilyTree.descendantsSearch(targariensCollection, nm.nextLine().toUpperCase(Locale.ROOT));
//                    (targariensCollection).forEach(System.out::println);
                case 3:
                    System.out.printf("enter the name of Targarien member: ");
                    Scanner srch = new Scanner(System.in);
                    String name = srch.nextLine().toUpperCase();
                    System.out.println(targariens.searchPerson(name));
                    break;

                default:
                    throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Wrong choice, mortal!");
        }
    }
}
