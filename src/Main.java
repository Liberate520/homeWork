public class Main {
    public static void main(String[] args) {
        Human h1 = new Human("Мария",Gender.FEMALE);
        Human h2 = new Human("Прохор",Gender.MALE);
        Human h3 = new Human("Борис",Gender.MALE, h2,h1);
        Human h4 = new Human("Олеся",Gender.FEMALE);
        Human h5 = new Human("Павел",Gender.MALE);
        Human h6 = new Human("Харлампий",Gender.MALE);
        Human h7 = new Human("Анна",Gender.FEMALE, h4, h5);
        Human h8 = new Human("Елена",Gender.FEMALE, h3, h7);
        Human h9 = new Human("Соня",Gender.FEMALE, h3, h7);
        Human h10 = new Human("Виктор",Gender.MALE, h3, h7);

        FamilyTree ft = new FamilyTree();
        ft.addHuman(h1);
        ft.addHuman(h2);
        ft.addHuman(h3);
        ft.addHuman(h4);
        ft.addHuman(h5);
        ft.addHuman(h6);
        ft.addHuman(h7);
        ft.addHuman(h8);
        ft.addHuman(h9);
        ft.addHuman(h10);

        System.out.println(ft.getAllHumans());

    }
}
