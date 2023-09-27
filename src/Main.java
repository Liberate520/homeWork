public class Main {
    public static void main(String[] args) {

        GenerationMain grandMother1_1 = new GenerationMain("Smith", "Linda", "15.06.1945", "25.05.2010", Gender.FEMALE);
        GenerationMain grandFather1_1 = new GenerationMain("Smith", "Robert", "10.07.1942", Gender.MALE);
        GenerationMain grandMother1_2 = new GenerationMain("Johnson", "Susan", "14.04.1949", "15.07.2011", Gender.FEMALE);
        GenerationMain grandFather1_2 = new GenerationMain("Johnson", "Michael", "12.02.1940", Gender.MALE);
        
        Human mother1_1 = new Human("Williams", "Jessica", "20.03.1975", Gender.FEMALE);
        Human father1_1 = new Human("Williams", "William", "22.06.1972", Gender.MALE);
        
        YngGeneration child1_1 = new YngGeneration("Williams", "Emily", "05.05.2005", Gender.FEMALE);
        YngGeneration child1_2 = new YngGeneration("Williams", "James", "18.09.2007", Gender.MALE);

        //Добавляем родителей
        mother1_1.addParent(grandMother1_1);
        mother1_1.addParent(grandFather1_1);
        father1_1.addParent(grandMother1_2);
        father1_1.addParent(grandFather1_2);

        child1_1.addParent(mother1_1);
        child1_1.addParent(father1_1);
        child1_2.addParent(mother1_1);
        child1_2.addParent(father1_1);

        //Добавляем детей
        grandMother1_1.addChild(mother1_1);
        grandFather1_1.addChild(mother1_1);
        grandMother1_2.addChild(father1_1);
        grandFather1_2.addChild(father1_1);

        mother1_1.addChild(child1_1);
        mother1_1.addChild(child1_2);
        father1_1.addChild(child1_1);
        father1_1.addChild(child1_2);

        FamilyTree familyTree = new FamilyTree(grandMother1_1);
        Human root = familyTree.getRoot();
        System.out.println("Человек: ");
        System.out.println(root);
        System.out.println("Дети: ");
        root.printChildrens();
        System.out.println("Родители:");
        root.printParents();

        System.out.println("Старшее поколение:");
        for(Human person: child1_2.getMainGen()) {
            System.out.println(person);
        }

        System.out.println("Старшее поколение:");
        for(Human person: child1_2.getMainGen()) {
            System.out.println(person);
        }

        System.out.println("Младшее поколение:");
        for(Human person: grandMother1_1.getYngGen()) {
            System.out.println(person);
        }
    }
}
