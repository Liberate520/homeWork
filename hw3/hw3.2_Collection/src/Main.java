

public class Main {
    public static void main(String[] args) {
        ListPassanger list1 = new ListPassanger();
        list1.addPassanger("Vladimir", "Solarev", 312414241);
        list1.addPassanger("Igor", "Solarev", 312415321);
        list1.addPassanger("Viktor", "Ivanov", 21312414);
        list1.addPassanger("Viktoria", "Ivanova", 1321213);
        list1.addPassanger("Oleg", "Sidorov", 36463634);

        for (Passanger passanger : list1) {
            System.out.println(passanger);
        }
    }
}
