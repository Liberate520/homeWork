public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree1 = new FamilyTree();
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



        /**
         * Добавляем детей экземпляру класса.
         */
        human1.addChildren(human2);
        human1.addChildren(human3);

        /**
         * Устанавливаем связи.
         */

        human1.addRelationShip(human4,TypeOfRelationship.Wife);
        human1.addRelationShip(human2,TypeOfRelationship.Son);
        human1.addRelationShip(human3,TypeOfRelationship.Daughter);



        /**
         * Исследование по заданному экземпляру класса.
         */
        output.showСhildren(human1, familyTree1.getMainTree());
        output.showAllRelationship(human1);




    }
}
