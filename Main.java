import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human cat = new Human("Cat", "Smith",
                null, null, null,
                Gender.Female, LocalDate.of(1970, 7, 28));
        Human tom = new Human("Tom", "Smith",
                null, null, null,
                Gender.Male, LocalDate.of(1973, 4, 21));
        Human sam = new Human("Sam", "Smith",
                null, null, null,
                Gender.Male, LocalDate.of(1990, 4, 23));
        cat.setChildren(sam);
        tom.setChildren(sam);
        sam.setMather(cat);
        sam.setFather(tom);
        System.out.println(sam.getParrents());
    }
}
