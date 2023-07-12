// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import model.FamalyTreeItem;
 // import model.FamilyTree;
 // import model.Gender;
 // import model.Human;
 import model.Service;
 import presenter.Presenter;
 import ui.Console;
 import ui.View;

public class Main {

    public static void main(String[] args) {

         View view = new Console();
         Service service = new Service();
         new Presenter(view, service);
         
          view.start();

        // Human anna = new Human("Анна", "Иванова", LocalDate.of(1970, 1, 1), Gender.FEMALE);
         // Human petr = new Human("Петр", "Иванов", LocalDate.of(1969, 5, 20), Gender.MALE);
         // Human irina = new Human("Ирина", "Петрова", LocalDate.of(1990, 10, 10), Gender.FEMALE, anna, petr, null, null,
         //         null);
         // Human aleksey = new Human("Алексей", "Иванов", LocalDate.of(1995, 3, 15), Gender.MALE, anna, petr, null, null,
         //         null);
         // Human mariya = new Human("Мария", "Иванова", LocalDate.of(1998, 12, 31), Gender.FEMALE, anna, petr, null, null,
         //         null);

         // // List<Human> brothers = new ArrayList<>();
         // brothers.add(aleksey);

         // // List<Human> sisters = new ArrayList<>();
         // sisters.add(mariya);

         // anna.setSisters(sisters);
         // petr.setBrothers(brothers);

       // System.out.println(anna);
       // System.out.println(petr);
       // System.out.println(irina);
       // System.out.println(aleksey);
       //  System.out.println(mariya);

        // FamilyTree familyTree = new FamilyTree();
        // familyTree.addHuman(anna);
        // familyTree.addHuman(petr);
        // familyTree.addHuman(irina);
        // familyTree.addHuman(aleksey);
        // familyTree.addHuman(mariya);

      //  List<Human> irinaParents = familyTree.getParents(irina);
      //  System.out.println("Ирины родители: " + irinaParents);

     //   List<Human> alekseySiblings = familyTree.getSiblings(aleksey);
     //   System.out.println("Братья и сестры Алексея: " + alekseySiblings);

        // List<FamalyTreeItem> annaChildren = anna.getChildren();

     //   System.out.println("Дети Анны: " + annaChildren);

//      System.out.println("--------------------------");
//      anna.childrenSortByName();
//      System.out.println("Дети Анны сортированные по имени: " + annaChildren);

//       System.out.println("--------------------------");
//       anna.childrenSortByAge();
//       System.out.println("Дети Анны сортированные по возрасту: " + annaChildren);

      // System.out.println("Дети Анны: " + annaChildren);
      // Serializer serializer = new HumanSerializer();
      // serializer.save(familyTree, "hw/OOP/homeWork/src/tree.txt");
      // FamilyTree loadedFamilyTree = (FamilyTree) serializer.load("hw/OOP/homeWork/src/tree.txt");
      // System.out.println("Загруженное дерево: " + loadedFamilyTree.toString());

    }
}