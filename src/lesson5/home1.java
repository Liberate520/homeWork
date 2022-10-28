package lesson5;

public class home1 {
    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
    public static void main(String[] args) {
        Phones phones = new Phones();
        phones.add("Василий Уткин", "89437896746");
        phones.add("Максим Потапов", "896573836589");
        phones.add("Максим Потапов", "8965547547465");
        phones.add("Дмитрий Валенский", "89227579944");
        phones.add("Александр Петров", "89294674667");
        phones.add("Мария Федорова", "89327889999");
        phones.add("Мария Федорова", "89327889998");
        phones.printPerson("Мария Федорова");
        phones.printPerson("Александр Петров");
        System.out.println();
        phones.printAll();
    }
}
