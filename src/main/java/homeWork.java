import java.time.LocalDate;

public class homeWork {
    public static void main(String[] args) {
        Human hum1 = new Human("Иванов Иван Иванович ", Gender.Man, LocalDate.of(1960, 2, 5));
        Human wom1 = new Human("Иванова Ирина Петровна ", Gender.Woman, LocalDate.of(1962, 5, 1));
        Human wom2_1 = new Human("Иванова Елена Ивановна ", Gender.Woman, LocalDate.of(1983, 2, 21));
        Human hum2 = new Human("Иванов Пётр Иванович ", Gender.Man, LocalDate.of(1980, 4, 5));
        Human wom2 = new Human("Иванова Светлана Андреевна ", Gender.Woman, LocalDate.of(1979, 8, 21));
        Human hum3 = new Human("Иванов Сергей Петрович ", Gender.Man, LocalDate.of(2000, 1, 1));
        Human wom3 = new Human("Иванова Олеся Николаевна ", Gender.Woman, LocalDate.of(2001, 5, 7));
        hum1.addChild(hum2);
        wom1.addChild(hum2);
        hum1.addChild(wom2_1);
        hum2.addChild(hum3);
        wom2.addChild(hum3);
        hum1.setSpouse(wom1);
        hum2.setSpouse(wom2);
        hum3.setSpouse(wom3);

        FamilyTree tree = new FamilyTree();
        tree.add(hum1);
        tree.add(wom1);
        tree.add(hum2);
        tree.add(wom2);
        tree.add(hum3);
        tree.add(wom3);
        tree.add(wom2_1);
        System.out.println(tree.getInfo());

    }
}
