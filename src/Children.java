//import java.util.ArrayList;
//import java.util.List;
//
//public class Children extends Human {
//    private List<Human> parents;
//
//    public Children(String name, String date) {
//        super(name, date);
//        parents = new ArrayList<>();
//    }
//
//    public void addParent(Human parent) {
//        parents.add(parent);
//    }
//
//    public void hasParent(Human parent) {
//        System.out.println(getName() + " - является ребенком - " + parent.getName());
//    }
//
//    @Override
//    public void displayFamilyTree() {
//        System.out.println(getName() + " (ребенок)");
//
//        for (Human parent : parents) {
//            System.out.println("\t" + parent.getName() + " (родитель)");
//
//        }
//    }
//}
