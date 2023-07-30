public class FamilyTree {
    public static void main(String[] args) {
      Person father = new Person("Vladislav", "Ivanov", 65, "Male");
      Person mother = new Person("Olga", "Ivanova", 62, "Female");
      Person daughter = new Person("Maria", "Ivanova", 22, "Female");
      Person son = new Person("Dmitriy", "Ivanov", 12, "Male");

        System.out.println(father);
        System.out.println(mother);
        System.out.println(daughter);
        System.out.println(son);
    }
}
