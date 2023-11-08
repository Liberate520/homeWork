import TreePack.FamilyTree;
import PersonPack.Gender;
import PersonPack.Person;
import UtilsPack.StorageTree;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FamilyTree tree = new FamilyTree();
        StorageTree storage = new StorageTree();
        String filepath = "tree.out";

        Person person  = new Person("Ann", Gender.female, "2022-01-01");
        Person parent1 = new Person("Bet", Gender.female,"1989-01-01");
        Person parent1_sibling = new Person("Ben", Gender.male,"1989-01-01");
        Person parent2 = new Person("Bob", Gender.male,"1999-01-01");
        Person grandma = new Person("Mary", Gender.female,"1966-01-01");

        tree.addPerson(person);
        tree.addPerson(parent1);
        tree.addPerson(parent1_sibling);
        tree.addPerson(parent2);
        tree.addPerson(grandma);

        tree.setParent1(person,parent1);
        tree.setParent2(person,parent2);
        tree.setParent1(parent1,grandma);
        tree.setParent1(parent1_sibling,grandma);


        System.out.println(tree.toString());
        storage.writeTree(tree, filepath);

        FamilyTree newTree = storage.restoreTree(filepath);
        //System.out.println(newTree.toString());

        //Уточнить, можно ли сохранить результат сортировки, чтобы потом его вывести как в примере с семинара
        //Раскомментировать если надо проверить сортировку по дате рождения
        //System.out.println("по дате:");
        //newTree.sortByAge();

        //Раскомментировать если надо проверить сортировку по количеству детей
        System.out.println("по детям:");
        newTree.sortByChildren();


//Раскомментировать, если надо проверить итератор
//        StringBuilder tmp = new StringBuilder("Family tree (with iterator):\n");
//        for (Person item : tree){
//            tmp.append(item.toString());
//            tmp.append("\n");
//            //System.out.println(item.getValue().toString());
//        }
//        System.out.println(tmp);

    }
}
