import Presenter.Presenter;
import UI.ConsoleUI;
import UI.View;
import familyApi.FamilyService;
import human.Gender;
import human.Human;
import tree.FamilyTree;

import java.util.Date;

public class program {
    public static void main(String[] args) throws Exception {
        //Создание экземпляров класса
        Human member1 = new Human("Ivanov Ivan", Gender.Male, new Date(64, 2, 23));
        Human member2 = new Human("Ivanova Maria", Gender.Female, new Date(70, 1, 5));
        Human member3 = new Human("Ivanov Sergey", Gender.Male, new Date(90, 8, 28), member2, member1);
        Human member4 = new Human("Ivanova Olga", Gender.Female, new Date(89, 11, 24), member2, member1);

        FamilyTree<Human> familyTree1 = new FamilyTree<>();
        //Добавление детей
//        member1.addChild(member3);
//        member2.addChild(member3);


        //Добавление членов семьи на семейное дерево
        familyTree1.addMembers(member1);
        familyTree1.addMembers(member2);
        familyTree1.addMembers(member3);
        familyTree1.addMembers(member4);
        //familyTree1.printMembers(); //печать всех членов семьи
        // Работа с меню
        View view = new ConsoleUI();
        FamilyService service = new FamilyService(familyTree1);
        Presenter presenter = new Presenter(view, service);

        view.start();

//        //Перебор всех членов семьи с помощью итератора
//        for (Human member: familyTree1
//             ) {
//            System.out.println(member.getAllInfo());
//        }
////Сортировка членов семьи
//        Service service = new Service(familyTree1);
//        service.sortByName();
//
//        System.out.println("Sort by name"); // Сортировка членов семьи по имени
//
//        for (Human member: familyTree1
//        ) {
//            System.out.println(member.getAllInfo());
//        }
//
//        System.out.println("Sort by date birth");
//        service.sortByDateBirth();
//
//        for (Human member: familyTree1
//        ) {
//            System.out.println(member.getAllInfo());
//        }



//        save.FileHandler fh = new save.FileHandler();
//        FamilyTree familyTree2 = new FamilyTree();
//
//        familyTree2 = fh.load(familyTree2, "fileInfo.txt"); // Загрузка дерева из файла, даже если в файле есть повторения, они не учитываются при формировании членов семьи
//        familyTree2.printMembers();
//        Human member5 = new Human("Ivanov Dmitry", Gender.Male, null, member3);
//        // Сохранение в файле
//        fh.saveHuman(member5, "fileInfo.txt");

    }


}
