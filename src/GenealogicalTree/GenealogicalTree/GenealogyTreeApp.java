package GenealogicalTree;

import java.io.*;
import java.util.*;

class Person extends Person_class {

    public Person(String name, String gender, String dateOfBirth, String dateOfDeath) {
        super(name, gender, dateOfBirth, dateOfDeath);
    }

}

interface PersonDataIO extends PersonDataIO_interface {
}

class PersonDataIOImpl extends PersonDataIOImpl_implements {
}


public class GenealogyTreeApp {
    private static List<Person> allPeople = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Choose an action:");
            System.out.println("1. View Full Tree");
            System.out.println("2. Added Post");
            System.out.println("3. Edit Post");
            System.out.println("4. Added children");
            System.out.println("5. Added parents");
            System.out.println("6. Delete Post");
            System.out.println("7. Write tree to file");
            System.out.println("8. Read tree from file");
            System.out.println("9. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    if (allPeople.isEmpty()) {
                        System.out.println("Tree is empty.");
                    } else {
                        System.out.println("Extended Tree:");
                        for (Person person : allPeople) {
                            System.out.println("Name: " + person.getName());
                            System.out.println("Gender: " + person.getGender());
                            System.out.println("Date of Birth: " + person.getDateOfBirth());
                            System.out.println("Date of Death: " + person.getDateOfDeath());
                            System.out.println("Parents:");
                            for (Person parent : person.getParents()) {
                                System.out.println("- " + parent.getName());
                            }
                            System.out.println("Дети:");
                            for (Person child : person.getChildren()) {
                                System.out.println("- " + child.getName());
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Date of Birth ");
                    String dateOfBirth = scanner.nextLine();
                    System.out.print("Enterdate of death (if applicable, otherwise leave blank): ");
                    String dateOfDeath = scanner.nextLine();

                    Person newPerson = new Person(name, gender, dateOfBirth, dateOfDeath);
                    allPeople.add(newPerson);

                    System.out.println("Post edited successfully.");
                    break;

                case 3:
                    System.out.print("Enter the name of the post you want to edit:");
                    String editName = scanner.nextLine();

                    Person editPerson = findPersonByName(editName);
                    if (editPerson != null) {
                        System.out.print("Enter new name: ");
                        editPerson.setName(scanner.nextLine());
                        System.out.print("Enter new Gender: ");
                        editPerson.setGender(scanner.nextLine());
                        System.out.print("Enter new Date of Birth: ");
                        editPerson.setDateOfBirth(scanner.nextLine());
                        System.out.print("Enter new date of death (if applicable, otherwise leave blank): ");
                        editPerson.setDateOfDeath(scanner.nextLine());

                        System.out.println("Post edited successfully.");
                    } else {
                        System.out.println("Post not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the name of the entry you want to add children to: ");
                    String parentName = scanner.nextLine();
                    Person parent = findPersonByName(parentName);
                    if (parent != null) {
                        System.out.print("Enter the number of children you want to add: ");
                        int numChildren = scanner.nextInt();
                        scanner.nextLine();

                        List<Person> children = new ArrayList<>();
                        for (int i = 0; i < numChildren; i++) {
                            System.out.print("Enter name of Child " + (i + 1) + ": ");
                            String childName = scanner.nextLine();
                            Person child = findPersonByName(childName);
                            if (child != null) {
                                parent.addChild(child);
                                child.addParent(parent);
                                children.add(child);
                            } else {
                                System.out.println("Child with name  " + childName + " not found.");
                            }
                        }

                        parent.addChildren(children);
                        System.out.println("Children successfully added.");
                    } else {
                        System.out.println("Parent with name " + parentName + " not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter the name of the entry you want to add parents to: ");
                    String childName = scanner.nextLine();
                    Person child = findPersonByName(childName);
                    if (child != null) {
                        System.out.print("Enter the number of parents you want to add: ");
                        int numParents = scanner.nextInt();
                        scanner.nextLine();

                        List<Person> parents = new ArrayList<>();
                        for (int i = 0; i < numParents; i++) {
                            System.out.print("ВEnter name of parent " + (i + 1) + ": ");
                            String parentsName = scanner.nextLine();
                            Person parent_1 = findPersonByName(parentsName);
                            if (parent_1 != null) {
                                child.addParent(parent_1);
                                parent_1.addChild(child);
                                parents.add(parent_1);
                            } else {
                                System.out.println("Parent with name " + parentsName + " not found.");
                            }
                        }

                        child.addParents(parents);
                        System.out.println("Parents was successfully added.");
                    } else {
                        System.out.println("Child with name " + childName + " not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter the name of the entry you want to delete: ");
                    String deleteName = scanner.nextLine();

                    Person deletePerson = findPersonByName(deleteName);
                    if (deletePerson != null) {
                        allPeople.remove(deletePerson);
                        for (Person parent_2 : deletePerson.getParents()) {
                            parent_2.removeChild(deletePerson);
                        }
                        for (Person child_1 : deletePerson.getChildren()) {
                            child_1.removeParent(deletePerson);
                        }
                        System.out.println("The entry was successfully deleted.");
                    } else {
                        System.out.println("Record not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter a file name for writing data: ");
                    String writeFilename = scanner.nextLine();
                    try {
                        PersonDataIO dataIO = new PersonDataIOImpl();
                        dataIO.writeData(allPeople, writeFilename);
                        System.out.println("Data successfully write from file: " + writeFilename);
                    } catch (IOException e) {
                        System.out.println("Error writing data from file: "+ writeFilename);
                    }
                    break;

                case 8:
                    System.out.print("Enter a file name for reading data: ");
                    String readFilename = scanner.nextLine();
                    try {
                        PersonDataIO dataIO = new PersonDataIOImpl();
                        allPeople = dataIO.readData(readFilename);
                        System.out.println("Data successfully read from file: " + readFilename);
                    } catch (IOException e) {
                        System.out.println("Error reading data from file: " + readFilename);
                    }
                    break;

                case 9:
                    System.out.println("Out of programm.");
                    break;
                default:
                    System.out.println("Wrong choice. Please, try again.");
            }
        } while (choice != 7);

        scanner.close();
        System.out.println("Programm closed.");
    }

    private static Person findPersonByName(String name) {
        for (Person person : allPeople) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }
    private static void writeDataToFile(String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Person person : allPeople) {
            writer.write(person.getName() + "," + person.getGender() + "," +
                    person.getDateOfBirth() + "," + person.getDateOfDeath() + "\n");

            List<Person> children = person.getChildren();
            List<Person> parents = person.getParents();

            if (!children.isEmpty()) {
                writer.write("Children:");
                for (Person child : children) {
                    writer.write("," + child.getName());
                }
                writer.write("\n");
            }

            if (!parents.isEmpty()) {
                writer.write("Parents:");
                for (Person parent : parents) {
                    writer.write("," + parent.getName());
                }
                writer.write("\n");
            }
        }
        writer.close();
    }

    private static void readDataFromFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] data = line.split(",");
            String name = data[0];
            String gender = data[1];
            String dateOfBirth = data[2];
            String dateOfDeath = data[3];

            Person person = new Person(name, gender, dateOfBirth, dateOfDeath);
            allPeople.add(person);

            if (line.startsWith("Children:")) {
                List<Person> children = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    String childName = data[i];
                    Person child = findPersonByName(childName);
                    if (child != null) {
                        children.add(child);
                        child.addParent(person);
                    }
                }
                person.addChildren(children);
            }

            if (line.startsWith("Parents:")) {
                List<Person> parents = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    String parentName = data[i];
                    Person parent = findPersonByName(parentName);
                    if (parent != null) {
                        parents.add(parent);
                        parent.addChild(person);
                    }
                }
                person.addParents(parents);
            }
        }
        bufferedReader.close();
    }
};