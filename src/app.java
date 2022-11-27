import java.util.List;

/**
 * app
 */
public class app {

    public static void main(String[] args) {
        Man father = new Man("Дмитрий", "Романов", 42, 182, 80);
        Woman mother = new Woman("Светлана", "Романова", 38, 160, 58);

        Family family = new Family(father, mother);
        family.addChild(new Man("Илья", "Романов", 3, 60, 10));
        family.addChild(new Man("Жан", "Романов", 3, 30, 15));
        family.addChild(new Man("Буч", "Романов", 6, 32, 14));
        family.addChild(new Woman("Мадина", "Романова", 3, 25, 13));
        
        Console.writeln(family.getChildren());
        System.out.println("-------------------------");
        Console.writeln(family.getSons());
        System.out.println("-------------------------");
        Console.writeln(family.getDaughters());
    }
}