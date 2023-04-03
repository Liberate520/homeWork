//public Person(String firstName, String lastName, String birthDate,
// String deathDate, Gender gender, int idMather, int idFather)

import java.io.InvalidObjectException;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        FamilyTree targariens = new FamilyTree();

        Person personA = new Person("JEHAELIS", "Targarien", "17.05.134", "24.12.200", Gender.male);
        Person personB = new Person("ALISANNA", "Targarien", "03.11.145", "20.08.233", Gender.female);
        Person personC = new Person("BELION", "Targarien", "24.01.158", "19.06.240", Gender.male, personB, personA);
        Person personD = new Person("ALISSA", "Targarien", "13.09.161", "18.04.248", Gender.female, personB, personA);
        Person personE = new Person("VIZERIS I", "Targarien", "22.12.179", "01.03.274", Gender.male, personD, personC);
        Person personF = new Person("DAEMON", "Targarien", "18.04.166", "12.08.283", Gender.male, personD, personC);
        Person personG = new Person("ALISERNTA", "Hightower", "12.03.179", "31.01.275", Gender.female);
        Person personH = new Person("HELEINA", "Targarien", "07.11.203", "08.05.299", Gender.female, personG, personE);

        targariens.addPerson(personA);
        targariens.addPerson(personB);
        targariens.addPerson(personC);
        targariens.addPerson(personD);
        targariens.addPerson(personE);
        targariens.addPerson(personF);
        targariens.addPerson(personG);
        targariens.addPerson(personH);

        System.out.println("\n1 - Output all members of the genus." +
                "\n2 - Find targarien descendance." +
                "\n3 - Find the great Targarien." +
                "\n4 - Download data into file.");
//                "\n5 - Upload data from file.");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        try {
            switch (option) {
                case 1:
                    System.out.println("Behold and bow before the great Targarien family!!!");
                    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><>");
                    System.out.println(targariens.getTreeInfo());
                    break;
                case 2:
                    System.out.printf("Enter the name of Targarien member to find he's descendance: ");
                    Scanner srchDesc = new Scanner(System.in);
                    String nameOfAsc = srchDesc.nextLine().toUpperCase();
                    System.out.println(targariens.searchPersonDescendance(nameOfAsc));
                    break;
                case 3:
                    System.out.printf("Enter the name of Targarien member: ");
                    Scanner srch = new Scanner(System.in);
                    String name = srch.nextLine().toUpperCase();
                    System.out.println(targariens.searchPerson(name));
                    break;
                case 4:
                    DataRepository dataRepositoryDown = new DataRepository();
                    dataRepositoryDown.dataOutput(targariens, personA);
                    break;
//                case 5:
//                    DataRepository dataRepositoryUp = new DataRepository();
//                    FamilyTree familyTree = dataRepositoryUp.deserialization();
//                    System.out.println(familyTree.getTreeInfo());
//                default:
//                    throw new Exception();
            }
        }catch (Exception e){
            System.out.println("Wrong choice, mortal!");
        }
    }
}
