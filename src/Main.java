public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(new Human("Иван", "Иванов", "25.10.1990", Gender.Male));
        familyTree.addHuman(new Human("Светлана", "Светлова", "14.05.1993", Gender.Female));
        familyTree.addHuman(new Human("Екатерина", "Иванова", "05.03.2012", Gender.Female,
                familyTree.getHuman("Светлана", "Светлова", "14.05.1993"),
                familyTree.getHuman("Иван", "Иванов", "25.10.1990")));
        familyTree.addHuman(new Human("Петр", "Иванов", "10.08.2015", Gender.Male,
                familyTree.getHuman("Светлана", "Светлова", "14.05.1993"),
                familyTree.getHuman("Иван", "Иванов", "25.10.1990")));
        familyTree.addHuman(new Human("Михаил", "Иванов", "18.12.2017", Gender.Male,
                familyTree.getHuman("Светлана", "Светлова", "14.05.1993"),
                familyTree.getHuman("Иван", "Иванов", "25.10.1990")));
        familyTree.addHuman(new Human("Сидр", "Светлов", "25.02.1970", Gender.Male));

        familyTree.getHuman("Светлана", "Светлова", "14.05.1993").setFather(familyTree.getHuman("Сидр", "Светлов", "25.02.1970"));

        System.out.println(familyTree.getHuman("Светлана", "Светлова", "14.05.1993").getFather());

        Human forFindBrother = familyTree.getHuman("Екатерина", "Иванова", "05.03.2012");
        System.out.println("Братья для " + forFindBrother.getFullName() + ':');
        System.out.println(familyTree.getBrothers(forFindBrother));

        Human forFindSister = familyTree.getHuman("Михаил", "Иванов", "18.12.2017");
        System.out.println("Сестры для " + forFindSister.getFullName() + ':');
        System.out.println(familyTree.getSisters(forFindSister));
    }

}
