package family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human sergei = new Human("Sergei", "Petrov", Genders.Мужской,
                LocalDate.of(1990, 1, 1), LocalDate.of(2005, 12, 31));
        System.out.println(sergei);
    }
}
