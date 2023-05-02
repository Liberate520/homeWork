package Tree.homeWork.src;

import Tree.homeWork.src.FamilyTreeGroup.FamilyTree;
import Tree.homeWork.src.HumanGroup.Human;
import Tree.homeWork.src.Presenter.Presenter;
import Tree.homeWork.src.model.Service;
import Tree.homeWork.src.ui.Console;
import Tree.homeWork.src.ui.View;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
//        Human human1 = new Human("Ivanov Stanislav Aleksandrovich", 33, 1990,2023, Gender.Male, TypeCommunication.son);
//        Human human2 = new Human("Ivanova",55,1968,0,Gender.Female, TypeCommunication.mother);
//        Human human3 = new Human("Misha", 3,2020,0,Gender.Male,TypeCommunication.children);
//        Human human4 = new Human("Babushka Galya", 75,1948,0,Gender.Female,TypeCommunication.grandmother);
//        ------------------------------------------------для работы с файлом:
        // String filePath = "Tree.homeWork/src/tree.txt";
        // WriteTo writeTo = new ToFile();
        // FamilyTree familyTree = new FamilyTree();
        // следующая строка с преобразованием для вывода инфо из файла (комментировать или предыдующую строку,
        // с добавлением людей и writeTo/ или следующую)
        //FamilyTree familyTree = (FamilyTree) writeTo.read(filePath);  // для чтения
        // writeTo.write(familyTree, filePath);    // для записи

//        familyTree.addHuman(human1);
//        familyTree.addHuman(human2);
//        familyTree.addHuman(human3);
//        familyTree.addHuman(human4);

//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.print("Введите данные о человеке '0' или команду '1' показать или 'q' для выхода): ");
//            String user_input = scanner.nextLine();
//            if (user_input.equals("0")){
//                Human human = new Human();        // РЕАЛИЗОВАТЬ ВВОД ДАННЫХ
//                familyTree.addHuman(human);
//            } else if (user_input.equals("1")) {
//                familyTree.getHumanList();
//                System.out.println(familyTree);
//            } else if (user_input.equals("q")) {
//                break;
//        }
//        scanner.close();
//        }
        //---------------------------------------------------------
        //часть для работы с пользователем
        View view = new Console();
        Service service = new Service();
        new Presenter(view, service);
        view.start();
        //---------------------------------------------------------
        System.out.println(familyTree.getHumanList());
        Human human = new Human(null);
        Iterator<String> components = human;
        while (components.hasNext()) {
            System.out.println(human.next());
        }
        service.sortByName();
        System.out.println(familyTree.getHumanList());
        service.sortByAge();
        System.out.println(familyTree.getHumanList());
    }
}
