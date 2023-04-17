package Package;
import java.time.LocalDate;
import java.util.ArrayList;


public class Program {
    
    public static void main(String[] args) {

        Person person10 = new Person("Иван", "Иванов", LocalDate.of(1948, 1, 22), null);
        Person person11 = new Person("Галина", "Иванова", LocalDate.of(1950, 5, 12), null);
        Person person20 = new Person("Артём", "Иванов", LocalDate.of(1973, 2, 25), null);
        Person person21 = new Person("Иван", "Иванов", LocalDate.of(1974, 3, 10), null);
        Person person30 = new Person("Анна", "Иванова", LocalDate.of(1993, 1, 30), null);
        Person person31 = new Person("Анастасия", "Иванова", LocalDate.of(1995, 1, 21), null);
        Person person32 = new Person("Василий", "Иванов", LocalDate.of(1995, 9, 28), null);
        Person person33 = new Person("Петр", "Иванов", LocalDate.of(1996, 10, 19), null);
        Person person34 = new Person("Валентина", "Иванова", LocalDate.of(1997, 8, 14), null);

        Tree father1 = new Tree();
        father1.setFather(person10);

        Tree mother1 = new Tree();
        mother1.setMother(person11);

        Tree children1 = new Tree(new ArrayList<>());
        children1.addMember(person20);
        children1.addMember(person21);

        System.out.println();
    }


    
}
