import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 = new Person("Vasiliy", "Arapov", Gender.male, 1995, null);
        Person person2 = new Person("Yaroslav", "Salamandra", Gender.male, 1989, null);
        Person person3 = new Person("Alina", "Salamandra", Gender.female, 1965, null);
        Person person4 = new Person("Vitalia", "Arapova", Gender.female, 2007, null);
        Person person5 = new Person("Vladimir", "Arapov", Gender.male, 1955, 2019);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);
        familyTree.addPerson(person5);
        person1.setFatherFirstName("Vladimir");
        person1.setFatherSecondName("Arapov");
        System.out.println(person1.getFatherFirstName());
        System.out.println(person1.getFatherSecondName());
        System.out.println(familyTree.getPersonByFirstSecondName("Vasiliy", "Arapov"));
        System.out.println(familyTree.getPersonByFirstSecondName(person1.getFatherFirstName(),
                person1.getFatherSecondName()));


        System.out.println(familyTree.getFamilyTree());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("familyTree.out"));
        objectOutputStream.writeObject(person1);
        objectOutputStream.writeObject(person2);
        objectOutputStream.writeObject(person3);
        objectOutputStream.writeObject(person4);
        objectOutputStream.writeObject(person5);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("familyTree.out"));
        Person person1Restored = (Person) objectInputStream.readObject();
        Person person2Restored = (Person) objectInputStream.readObject();
        Person person3Restored = (Person) objectInputStream.readObject();
        Person person4Restored = (Person) objectInputStream.readObject();
        Person person5Restored = (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("Before Serialize: " + "\n" + person1 + "\n" + person2 +
                "\n" + person3+ "\n" + person4 + "\n" + person5);
        System.out.println("After Restored: " + "\n" + person1Restored + "\n" + person2Restored +
                "\n" + person3Restored + "\n" + person4Restored + "\n" + person5Restored);
    }
}
