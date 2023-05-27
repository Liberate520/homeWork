package HW1;

import static HW1.Tree.ruriks;

public class Main {
    public static void main(String[] args) {

        ruriks.showParents("Рюрик");
        ruriks.showChildren("Рюрик");
        ruriks.showChildren("Игорь");
        ruriks.showChildren("Святослав");
        ruriks.showParents("святослав");
        System.out.println(ruriks.getPerson("игорь"));
    }
}
