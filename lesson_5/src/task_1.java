// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
// что 1 человек может иметь несколько телефонов.
/**
 * task_1
 */
public class task_1 {

    public static void main(String[] args) {
        Phones phones = new Phones();
        phones.add("Петр Аникин", "89437896746");
        phones.add("Валерий Разумовский", "896573836589");
        phones.add("Кирилл Валенский", "89227579944");
        phones.add("Александр Ухов", "89294674667");
        phones.add("Мария Федорова", "89327889999");
        phones.add("Мария Федорова", "89327889998");
        phones.printPerson("Мария Федорова");
        phones.printPerson("Кирилл Валенский");
    }
}