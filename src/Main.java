import FamilyTree.FamilyTree;
import FamilyTree.FileHolder;
import Person.Person;
import Person.Sex;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Заводим экземпляры класса
        Person john = new Person("John", LocalDate.of(1990,12, 9), Sex.male);
        Person max = new Person("Max", LocalDate.of(1978,8, 4), Sex.male);
        Person mary = new Person("Maria", LocalDate.of(1979,4, 2), Sex.female);
        Person julia = new Person("Julia", LocalDate.of(1992,2, 8), Sex.female);
        Person zoe = new Person("Zoe", LocalDate.of(2009,1, 1), Sex.female);
        FamilyTree tree = new FamilyTree();
        tree.addPerson(john);tree.addPerson(max);tree.addPerson(mary);tree.addPerson(julia);tree.addPerson(zoe);

        // Тестируем как работают связи
        julia.spouse = john;
        max.spouse = mary;
        zoe.setChild(max, zoe);
//        System.out.println(mary.children);
        System.out.println(tree);

        //Тестируем iterable
//        for(Person somebody: tree){
//            System.out.println(somebody);
//        }

        //Тестируем comparable (sort);
        tree.sortByName();
        System.out.println(tree);
        tree.sortByBirthday();
        System.out.println(tree);

        // Тестируем как производится запись в файл и из файла.
//        FileHolder fh = new FileHolder();
//        fh.save(tree);
//        FamilyTree newTree = fh.read();
//        System.out.println(newTree);
    }

}
