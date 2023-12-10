import model.GenealogyTree;
import model.Person;
import io.FileHandler;

import java.io.IOException;
import java.util.List;

import view.GenealogyTreeView;
import presenter.GenealogyTreePresenter;
import presenter.GenealogyTreePresenterImpl;

public class Main {
    public static void main(String[] args) {
        GenealogyTree<Person> genealogyTree = new GenealogyTree<>();
        
        // Creating instances of Person to represent individuals in the genealogical tree
        Person person1 = new Person("Someone 1", "xxx", "1990-01-01", "male");
        Person person2 = new Person("Someone 2", "xxx", "1992-02-02", "female");
        Person person3 = new Person("Someone 3", "xxx", "1985-03-03", "male");

        // Adding individuals to the genealogical tree
        genealogyTree.addPerson("Someone 1", person1);
        genealogyTree.addPerson("Someone 2", person2);
        genealogyTree.addPerson("Someone 3", person3);

        // Creating parent-child relationships in the genealogical tree
        genealogyTree.addChild("Someone 1", "xxx");
        genealogyTree.addChild("Someone 2", "xxx");

        // Writing the genealogical tree to a file using serialization
        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.writeToFile("genealogyTree.ser", genealogyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading the genealogical tree from the serialized file
        try {
            FileHandler fileHandler = new FileHandler();
            GenealogyTree<Person> loadedTree = fileHandler.readFromFile("genealogyTree.ser");
        
            // Displaying information about people in the loaded genealogical tree
            System.out.println("People in the loaded genealogy tree:");
            for (Person person : loadedTree) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sorting individuals in the genealogical tree by name and displaying the sorted list
        List<Person> sortedByName = genealogyTree.sortByName();
        System.out.println("Sorted by name:");
        for (Person person : sortedByName) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }

        // Sorting individuals in the genealogical tree by date of birth and displaying the sorted list
        List<Person> sortedByDateOfBirth = genealogyTree.sortByDateOfBirth();
        System.out.println("Sorted by date of birth:");
        for (Person person : sortedByDateOfBirth) {
            System.out.println(person.getFirstName() + " " + person.getLastName() + " - " + person.getDateOfBirth());
        }
    }
}
