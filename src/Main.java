// Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:
// модель человека
// компонента хранения связей и отношений между людьми: родитель, ребёнок - 
// классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
// компонент для проведения исследований
// дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку 
// и сохранения в файл, получение\построение отдельных моделей человека
// Под “проведением исследования” можно понимать получение всех детей выбранного человека.

// Сделать PR к проекту: https://github.com/Liberate520/homeWork
// В качестве ответа указать ссылку на PR

public class Main {
    public static void main(String[] args) {
        FamilyTree family1 = new FamilyTree();
        FamilyTree family2 = new FamilyTree();

        Human mother1 = new Human("Vi", "Sol", Gender.Female, "30");
        Human father1 = new Human("Vo", "Sol", Gender.Male, "29");
        Human child1 = new Human("Tr", "Sol", Gender.Male, "10");

        Human mother2 = new Human("Kate", "Ivanova", Gender.Female, "30");
        Human father2 = new Human("Ivan", "Ivanov", Gender.Male, "29");
        Human child2 = new Human("Den", "Ivanov", Gender.Male, "10");
        Human child3 = new Human("Alisa", "Ivanova", Gender.Female, "10");
        Human child4 = new Human("Sveta", "Ivanova", Gender.Female, "10");

        family1.addRelation(father1, mother1, Relation.Husband);
        family1.addRelation(mother1, father1, Relation.Wife);
        family1.addRelation(child1, father1, Relation.Son);

        family2.addRelation(mother2, father2, Relation.Wife);
        family2.addRelation(father2, mother2, Relation.Husband);
        family2.addRelation(child2, father1, Relation.Son);
        family2.addRelation(child3, child2, Relation.Sister);
        family2.addRelation(child3, mother1, Relation.Daughter);
        family2.addRelation(child2, child4, Relation.Brother);
        
        System.out.println("Family1");
        System.out.println(family1);
        System.out.println("---------------");
        System.out.println("Family2");
        System.out.println(family2);

        Animal dog1 = new HomeAnimal("Zeus", "grey", TypeAnimal.Dog);
        Animal pig1 = new HomeAnimal("Pumba", "brown", TypeAnimal.Minipig);
        Animal cat1 = new HomeAnimal("Mars", "white", TypeAnimal.Cat);
        Animal hamster1 = new HomeAnimal("Ham", "orange", TypeAnimal.Hamster);

        System.out.println("---------------");
        System.out.println(dog1);
        HumanOwnsAnimal own1 = new HumanOwnsAnimal();
        own1.addAnimal(child4, hamster1, RelationAnimal.owner);
        own1.addAnimal(child4, dog1, RelationAnimal.owner);
        System.out.println(own1);   
    }
}
