import human.Gender;
import human.Human;
import tree.FamilyTree;

public class program {
    public static void main(String[] args) throws Exception {
        //Создание экземпляров класса
        Human member1 = new Human("Ivanov Ivan", Gender.Male);
        Human member2 = new Human("Ivanova Maria", Gender.Female);
        Human member3 = new Human("Ivanov Sergey", Gender.Male, member2, member1);
        Human member4 = new Human("Ivanova Olga", Gender.Female, member2, member1);

        FamilyTree familyTree1 = new FamilyTree();
        //Добавление детей
//        member1.addChild(member3);
//        member2.addChild(member3);


        //Добавление членов семьи на семейное дерево
        familyTree1.addMembers(member1);
        familyTree1.addMembers(member2);
        familyTree1.addMembers(member3);
        familyTree1.addMembers(member4);
        //familyTree1.printMembers(); //печать всех членов семьи

        //Перебор всех членов семьи с помощью итератора
        for (Human member: familyTree1
             ) {
            System.out.println(member.getAllInfo());
        }
//Сортировка членов семьи
        Service service = new Service(familyTree1);
        service.sortByName();

        System.out.println("Sort by name"); // Сортировка членов семьи по имени

        for (Human member: familyTree1
        ) {
            System.out.println(member.getAllInfo());
        }


//        FileHandler fh = new FileHandler();
//        FamilyTree familyTree2 = new FamilyTree();
//
//        familyTree2 = fh.load(familyTree2, "fileInfo.txt"); // Загрузка дерева из файла, даже если в файле есть повторения, они не учитываются при формировании членов семьи
//        familyTree2.printMembers();
//        Human member5 = new Human("Ivanov Dmitry", Gender.Male, null, member3);
//        // Сохранение в файле
//        fh.saveHuman(member5, "fileInfo.txt");

    }


}
