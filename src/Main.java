import java.io.IOException;

import model.allcommands.Command;

import presenter.Presenter;
import view.MyView;

public class Main  {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MyView myView = new MyView();
        Command command = new Command();
        Presenter presenter = new Presenter(command, myView);
        myView.start();


    //FamilyTree<ElementTree> familyTreeHuman = new FamilyTree();
   

//        System.out.println("Выберите режим работы работы с древом");
//       test.getCommandLlistWork().get(4).execute();
//
//        for (int i = 0; i < test.getCommandList().size(); i++) {
//           System.out.println(i+": " +test.getCommandList().get(i).discription());
//        }
////        ElementTree<> = test.getCommandList().get(1);
//
//        System.out.println(" ");
//
////
//       FamilyTree<Human> familyTreeHuman = new FamilyTree();
////
//        System.out.println("Выберите команду ");
//         test.getCommandList().get(0).execute();
//        for (int i = 0; i < test.getCommandLlistWork().size(); i++) {
//            System.out.println(i+": " +test.getCommandLlistWork().get(i).discription());
//        }


////
//       FamilyTree<Human> familyTreeHuman = new FamilyTree();
//        FamilyTree<Cats> familyTreeCats = new FamilyTree();

////        //разкомментировать для создания файла backup ниже
//        ElementTree<Human> h1 = new Human("Ivan", "Male", 66);
//        ElementTree <Human> h2 = new Human("Ola", "FeMale", 62);
//        ElementTree<Human> h3 = new Human("Sana", "Male", 44,(Human) h1,(Human) h2);
//        ElementTree<Human>  h4 = new Human("Kola", "Male", 45, (Human)h1, (Human)h2);
//        ElementTree<Human>  h5 = new Human("Tana", "FeMale", 23,(Human) h1, (Human)h2);
//        ElementTree<Human>  h6 = new Human("Dasha", "FeMale", 6,(Human) h3, (Human)h5);
//////
//        ElementTree<Cats> c1 = new Cats("Vaska", "Male", 2);
//        ElementTree<Cats> c2 = new Cats("Milka", "FeMale",1);
//        ElementTree<Cats> c3 = new Cats("Murka", "FeMale",5);
//        ElementTree<Cats> c4 = new Cats("Kotic", "Male",7);
//        ElementTree<Cats> c5 = new Cats("Barni", "Male",6);
//
//        familyTreeHuman.addElement((Human) h1);
//        familyTreeHuman.addElement((Human) h2);
//        familyTreeHuman.addElement((Human) h3);
//        familyTreeHuman.addElement((Human) h4);
//        familyTreeHuman.addElement((Human) h5);
//        familyTreeHuman.addElement((Human) h6);
//
//        familyTreeHuman.printAllTree();

//        test.getCommandLlistWork().get(4).execute();


//        familyTreeCats.addElement((Cats) c1);
//        familyTreeCats.addElement((Cats) c2);
//        familyTreeCats.addElement((Cats) c3);
//        familyTreeCats.addElement((Cats) c4);
//        familyTreeCats.addElement((Cats) c5);
////
//   familyTreeHuman.write(); // запись файла
////     familyTreeCats.write(); // запись файла
////       familyTreeHuman.read(); // чтение файла
////        familyTreeCats.read();
//
    //   familyTreeHuman.printAllTree();  // печать всех членов дерева
        // familyTreeCats.printAllTree();
//
//       System.out.println("Поиск по имени человека ");
// System.out.println(familyTreeHuman.findByName("Ola").toString());
//        System.out.println(familyTreeHuman.findChild(familyTreeHuman.findByName("Ola")));
//       System.out.println(familyTreeHuman.findParents(familyTreeHuman.findByName("Ola")));
//       System.out.println(" ");
//
//       System.out.println("Поиск по имени человека ");
//        System.out.println(familyTreeHuman.findByName("Tana").toString());
//       System.out.println(familyTreeHuman.findChild(familyTreeHuman.findByName("Tana")));
//   System.out.println(familyTreeHuman.findParents(familyTreeHuman.findByName("Tana")));
//
//   System.out.println("Поиск по имени кота ");
//   System.out.println(familyTreeCats.findByName("Milka").toString());
//
////
//         System.out.println("Исходный список");
//         for (Object human :  familyTreeHuman){
//             System.out.println(human); }
//         System.out.println(" ");
//         for (Object cat :  familyTreeCats){
//             System.out.println(cat); }
//
//
//         System.out.println("Сортировка по возрасту");
//         familyTreeHuman.sortingByAge();
//         familyTreeCats.sortingByAge();
//
//         for (Object human :  familyTreeHuman){
//           System.out.println(human); }
//         System.out.println(" ");
//         for (Object cat :  familyTreeCats){
//             System.out.println(cat); }

//         System.out.println("Сортировка по имени");
//          familyTreeHuman.sortingByName();
//          familyTreeCats.sortingByName();
//
//          for (Human human :  familyTreeHuman){
//            System.out.println(human); }
//         System.out.println(" ");
//         for (Object cat :  familyTreeCats){
//             System.out.println(cat); }


    }


}



