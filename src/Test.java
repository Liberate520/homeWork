public class Test {
    public static void main(String[] args) {
        Human nick = new Human("Никита Петров", 22, Gender.male);
        Human mama = new Human("Елена Петрова", 45, Gender.female);
        Human papa = new Human("Евгений Петров", 46, Gender.male);
        nick.setMother(mama);
        nick.setFather(papa);

        FamilyTree family = new FamilyTree();
        family.addRelative(nick);
        family.addRelative(mama);
        family.addRelative(papa);
//        family.showAllRelatives();
//        mama.showKids();
//        papa.showKids();
        Human brother = new Human("Лев Урматский", 15, Gender.male, mama, papa);
        Human sister = new Human("Анастасия Урматская", 6, Gender.female, mama, papa);
        family.addRelative(brother);
        family.addRelative(sister);
        family.updateKids();

        mama.showKids();
        System.out.println();
        nick.findSiblings();
        System.out.println();
        brother.findSiblings();
    }
}
