import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", LocalDate.of(1990,12, 9), Sex.male);
        Person max = new Person("Max", LocalDate.of(1978,8, 4), Sex.male);
        Person mary = new Person("Maria", LocalDate.of(1979,4, 2), Sex.female);
        Person julia = new Person("Julia", LocalDate.of(1992,2, 8), Sex.female);
        Person zoe = new Person("Zoe", LocalDate.of(2009,1, 1), Sex.female);
        FamilyTree tree = new FamilyTree();
        tree.addPerson(john);
        tree.addPerson(max);
        tree.addPerson(mary);
        tree.addPerson(julia);
        tree.addPerson(zoe);
        julia.spouse = john;
        max.spouse = mary;
        john.setChild(max, zoe);
//        System.out.println(john.children);
        FileHolder fh = new FileHolder();
        fh.output(max); // в базе данных проблемы с кодировкой.
        fh.input();
//        System.out.println(tree);
    }
}
