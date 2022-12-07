public class Main {
    public static void main(String[] args) {

        FamilyTree<Human> familyTree1 = new FamilyTree<>();
        Output output = new Output();

        /**
         * Создаем экземпляры класса человек.
         */
        Human human1 = new Human("Cidorov",1, TypeOfGender.Male,
                null,null);
        familyTree1.addHuman(human1);

        Human human2 = new Human("Ivanov",2, TypeOfGender.Male,
                human1,null);
        familyTree1.addHuman(human2);

        Human human3 = new Human("Petrova",3, TypeOfGender.Female,
                human1,null);
        familyTree1.addHuman(human3);

        Human human4 = new Human("Cidorova",4, TypeOfGender.Female,
                null,null);
        familyTree1.addHuman(human4);

        Human human5 = new Human("Aidorova",5, TypeOfGender.Female,
                null,null);
        familyTree1.addHuman(human5);



        /**
         * Добавляем детей экземпляру класса.
         */
        human1.addChildren(human2);
        human1.addChildren(human3);

        /**
         * Устанавливаем связи.
         */

        human1.addRelationShip(human4,human1, TypeOfRelationship.Wife);
        human1.addRelationShip(human2,human1, TypeOfRelationship.Son);
        human4.addRelationShip(human2,human4, TypeOfRelationship.Son);
//        human1.addRelationShip(human3,TypeOfRelationship.Daughter);



        /**
         * Исследование по заданному экземпляру класса.
         */
//        output.showСhildren(human1, familyTree1.getMainTree());
        output.showAllRelationship(human1);
        output.showAllRelationship(human4);
        output.showAllRelationship(human2);
        output.showAllRelationship(human5);

        /**
         * Тестирую сортировку по фамилии(все получилось).
         */

//        familyTree1.sort();

        /**
         * Тестирую итератор.
         */
        output.showAllPerson(familyTree1);

        /**
         * Тестирую компоратор на сортировку по количеству связей.
         */

        familyTree1.sortByCountDegree();

        output.showAllPerson(familyTree1);












    }
}
