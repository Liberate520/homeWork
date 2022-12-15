package TASK2;
/**
 * Создайте класс, который представляет из себя коллекцию,
 * добавьте 2 метода add и get для работы с коллекцией.
 * Реализуйте возможность использования цикла for-each для работы с данной коллекцией.
 * Для этого реализуйте интерфейс Iterable и создайте итератор
 */
public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addContact("Bob", 79797);
        phoneBook.addContact("Josh", 12345);
        phoneBook.addContact("Jane", 78919);
        phoneBook.addContact("Michel", 45679);
        phoneBook.addContact("Sara", 19773);
        phoneBook.addContact("Ray", 43185);
        phoneBook.sortByName();
        for (Contact contact : phoneBook) {
            System.out.println(contact);
        }
        phoneBook.getContact("Bob");
    }
}
