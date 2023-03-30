public class program {
    public static void main(String[] args) {
        //Создание экземпляров класса
        Human member1 = new Human("Ivanov Ivan");
        Human member2 = new Human("Ivanova Maria");
        Human member3 = new Human("Ivanov Sergey", member2, member1);
        Human member4 = new Human("Ivanova Olga", member2, member1);

        FamilyTree familyTree1 = new FamilyTree();
        //Добавление детей
        member1.addChild(member3);
        member2.addChild(member3);
        member1.addChild(member4);
        member2.addChild(member4);
        //Печать всех детей, если детей нет возвращает "None"
        System.out.println("Children of " + member1.toString() + " : " + member1.printChildren());
        System.out.println("Children of " + member3.toString() + " : " + member3.printChildren());

        //Добавление членов семьи на семейное дерево
        familyTree1.addMembers(member1);
        familyTree1.addMembers(member2);
        familyTree1.addMembers(member3);
        familyTree1.addMembers(member4);
        familyTree1.printMembers(); //печать всех членов семьи
    }
}
