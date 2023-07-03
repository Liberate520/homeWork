public static void main(String[] args) {
        TreeFamily tree = new TreeFamily();
        Human Elena = new Human("Елена", 43);
        Human Vladimir = new Human("Владимир", 65);
        Human Anastasia = new Human("Анастасия", 23);
        Human Anton = new Human("Антон", 12);
        tree.addWifeAndHusband(Elena, Vladimir);
        tree.addDadForChildren(Vladimir, Anastasia);
        tree.addDadForChildren(Vladimir, Anton);
        tree.addMomForChildren(Elena, Anastasia);
        tree.addMomForChildren(Elena, Anton);


        Methods x = new Methods(tree);
        System.out.println("Дети Елены: ");
        x.findKidsWifeOrHus(Elena, Communication.mother);

        System.out.println("Дети Владимира: ");
        x.findKidsWifeOrHus(Vladimir, Communication.father);

        System.out.println("Мама Насти: ");
        x.findMomOrDad(Anastasia, Communication.mother);

        System.out.println("Папа Антона: ");
        x.findMomOrDad(Anton, Communication.father);

        System.out.print("Когда родилась Настя, ее маме было ");
        x.ageDiff(Anastasia, Communication.mother);

        System.out.print("Когда родился Антон, его папе было ");
        x.ageDiff(Anton, Communication.father);


    }
}