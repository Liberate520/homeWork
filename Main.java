package HW_2;

public class Main {
    public static void main(String[] args) {
        FamilyTree family1 = new FamilyTree();
        Human mother1 = new Human("Мария", Gender.female);
        Human father1 = new Human("Иван", Gender.male);
        Human child1 = new Human("Петр", mother1, father1, Gender.male, null, null);
        Human child2 = new Human("Алиса", mother1, father1, Gender.female, null, null);
        Human child3 = new Human("Костя", mother1, father1, Gender.male, null, null);

        family1.addHuman(mother1);
        family1.addHuman(father1);
        family1.addHuman(child1);
        family1.addHuman(child2);
        family1.addHuman(child3);

        System.out.println(family1);
    }

}
