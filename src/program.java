public class program {
    public static void main(String[] args) {
        Human kostya = new Human("kostya", "la", Gender.Male, 199);
        Human marina = new Human("marina", "ma", Gender.Female, 199);
        Human kot = new Human("kot", "lakr", Gender.Male, 201, kostya, marina);
        Human slava = new Human("Slava", "lcsd", Gender.Male, 199, kostya, marina);
        Human sasha = new Human("Sasha", "fdf", Gender.Female, 199);
        Human alex = new Human("Alexandr", "popo", Gender.Male, 201);
        Human irin = new Human("Irinna", "adad", Gender.Male, 199, sasha, alex);
        Human stepan = new Human("Stepan", "erty", Gender.Female, 199, irin, kot);
        Human lokki = new Human("Lokki", "rerere", Gender.Male, 201, irin, kot);
        Human trama = new Human("Tramm", "qwerty", Gender.Female, 199);
        stepan.addSpouse(trama);
        Human fred = new Human("Fred", "rzzd", Gender.Male, 199, stepan, trama);
        Human ivan = new Human("Ivan", "reserv", Gender.Male, 201, stepan, trama);
        Human fedya = new Human("Fedr", "brety", Gender.Male, 199);
        Human petr = new Human("Petr", "ma", Gender.Female, 199, fedya, ivan);
        Human luka = new Human("Luki", "popade", Gender.Male, 201, fedya, ivan);

        System.out.println(kostya.childs());
        //System.out.println(FamilyTree.humans);
        System.out.println(kot.parents());
        System.out.println(kostya.parents());
        System.out.println(FamilyTree.AllRelations(stepan));
    }
}
