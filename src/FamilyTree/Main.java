package family_tree.FamilyTree;

import family_tree.FamilyTree.Person.Gender;
import family_tree.FamilyTree.Person.Person;
import family_tree.FamilyTree.Servce.TempSupport;
import family_tree.FamilyTree.Tree.FamilyTree;
import family_tree.FamilyTree.Tree.FileManager;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;


public class Main {

    public static void main(String[] args) throws IOException {
//        TempSupport.manualVariant();
        //FamilyTree myTree = new FamilyTree();

        //TODO проблемы с нахождением файла. доработать
        FileManager importTree = new FileManager("new_tree.txt");
        FamilyTree myTree = importTree.read();

//        Person pers = new Person("Popova", "Ksenia", Gender.Female, LocalDate.of(1958,10, 2));
//        myTree.addPerson(pers);
//        myTree.getForInn(1).setParents(pers);
//        importTree.write(myTree);

        Iterator<Person> iterator = myTree.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getInfo());
        }

        myTree.sortByName();

        System.out.println("\nsort by last name");
        for (Person item : myTree) {
            System.out.println(item.getInfo());
        }


        myTree.sortByAge();

        System.out.println("\nsort by Age");
        for (Person item : myTree) {
            System.out.println(item.getInfo() + " - " + item.getDataBirth());
        }


    }

}
