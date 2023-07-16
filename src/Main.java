

public class Main {
    public static void main(String[] args) {
        Person egor = new Person("Егор", "Меньшиков", "Леонидович",
                Gender.MALE, 1986, null, 2100);
        Person petr = new Person("Петр", "Меньшиков", "Леонидович",
                Gender.MALE, 1988);
        Person marina = new Person("Марина", "Меньшикова", "Рудольфовна",
                Gender.FEMALE,1957,"Блохинцева");
        System.out.println(egor);
        System.out.println(petr);
        System.out.println(marina);
        System.out.println(marina.getMaidenName());
    }
}
