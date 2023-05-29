package HW1;

import static HW1.Trees.ruriks;

public class Main {
    public static void main(String[] args) {

        ruriks.showParents("Рюрик",879);
        ruriks.showChildren("Рюрик",879);
        ruriks.showChildren("Игорь",945);
        ruriks.showChildren("Святослав",972);
        ruriks.showParents("святослав",972);
        System.out.println(ruriks.getPersonFromTree("Ольга",969));
        System.out.println(ruriks.getPersonFromTree("игорь",945));
        ruriks.showParents("Борис",1078);
        ruriks.showParents("Борис",1015);
    }
}
