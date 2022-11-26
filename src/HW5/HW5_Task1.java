package HW5;

public class HW5_Task1 {
    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();

        book.printBook();

        book.add("7(555)812-6200", "Ivan");
        book.add("7(555)812-2222", "Ivan");
        book.add("7(555)951-9823", "Olga");
        book.add("7(655)753-9547", "Ilya");
        book.add("7(785)654-8853", "Helga");
        book.add("7(920)852-6587", "Zheka");
        book.add("7(893)123-6644", "Sasha");
        book.printBook();

        System.out.println();

        book.remove("7(893)123-6644");
        book.printBook();

        System.out.println();

        System.out.println(book.findName("7(920)852-6587"));
        System.out.println(book.findName("7(920)852-6588"));
        System.out.println(book.findNumber("Ivan"));
        System.out.println(book.findNumber("Iva"));
    }
}
