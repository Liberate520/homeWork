import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree ft = new Tree();
        ft.addPerson(new Person("Татьяна", LocalDate.of(1951, 1, 10), Gender.Female));
        ft.addPerson(new Person("Сергей", LocalDate.of(1951, 10, 23), Gender.Male));
        ft.addPerson(new Person("Алексей", LocalDate.of(1984, 7, 11), Gender.Male, ft.findPersonByName("Татьяна"), ft.findPersonByName("Сергей")));
        ft.addPerson(new Person("Ирина", LocalDate.of(1987, 7, 1), Gender.Female));
        ft.addPerson(new Person("Степан", LocalDate.of(2017, 4, 21), Gender.Male, ft.findPersonByName("Ирина"), ft.findPersonByName("Алексей")));
        ft.addPerson(new Person("Петр", LocalDate.of(2018, 9, 30), Gender.Male, ft.findPersonByName("Ирина"), ft.findPersonByName("Алексей")));
        ft.addPerson(new Person("Маша", LocalDate.of(2021, 6, 14), Gender.Female, ft.findPersonByName("Ирина"), ft.findPersonByName("Алексей")));
        ft.addPerson(new Person("Вика", LocalDate.of(2021, 6, 14), Gender.Female, ft.findPersonByName("Ирина"), ft.findPersonByName("Алексей")));

        System.out.println("\nЛица в генеалогическом дереве:");
        Lib.printList(ft.getPersonList());
        System.out.println();
        System.out.println("Папой для лица \"" + ft.findPersonByName("Степан") + "\" является:\n" +  ft.findPersonByName("Степан").getFather());
        System.out.println();
        System.out.println("Мамой для лица \"" + ft.findPersonByName("Алексей") + "\" является:\n" +  ft.findPersonByName("Алексей").getMother());
        System.out.println();
        System.out.println("Родителями для лица \"" + ft.findPersonByName("Степан") + "\" являются:");
        Lib.printList(ft.findPersonByName("Степан").getParents());
        System.out.println();
        System.out.println("Детьми для лица \"" + ft.findPersonByName("Татьяна") + "\" являются:");
        Lib.printList(ft.findPersonByName("Татьяна").getChildren());
        System.out.println("Братьями и сетстрами для лица \"" + ft.findPersonByName("Вика") + "\" являются:");
        Lib.printList(ft.findSiblings(ft.findPersonByName("Вика")));
    }

}