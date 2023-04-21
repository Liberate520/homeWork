package familyTree;

public class Main {
    public static void main(String[] args) {
        FamilyTree newTree = new FamilyTree();
        newTree.addNewHuman(new Human("Иванов", "Пётр", "Николаевич",
                Gender.male, "31.03.1973", "",
                "Иванова Анна Ивановна", "Иванов Николай Васильевич",
                "Иванова Елена Степановна",
                "Сидорова Мария Петровна, Петрова Ольга Петровна"));
        newTree.addNewHuman(new Human("Сидорова", "Мария", "Петровна",
                Gender.female, "04.11.1994", "",
                "Иванова Елена Степановна", "Иванов Пётр Николаевич",
                "Сидоров Павел Константинович",
                "Сидоров Семён Павлович, Сидорова Елизавета Павловна"));
        newTree.addNewHuman(new Human("Петрова", "Ольга", "Петровна",
                Gender.female, "21.05.1997", "",
                "Иванова Елена Степановна", "Иванов Пётр Николаевич",
                "Петров Александр Максимович",
                "Петрова Ксения Александровна, Петрова Вера Александровна"));
        System.out.print(newTree.searchHuman("Петрова Ольга Петровна"));
        System.out.println(newTree.showAll());
    }
}
