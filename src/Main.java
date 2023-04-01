public class Main {
    public static void main(String[] args) {
        Person Tom = new Person("Tom", "Geller", true);
        Person Fred = new Person("Fred", "Geller", true);
        Person Katya = new Person("Katya", "Geller", false);
        Person Vanya = new Person("Vanya", "Geller", true);
        Person Nastya = new Person("Nastya", "Geller", false);
        Person Lora = new Person("Lora", "Geller", true);
        Person Masha = new Person("Masha", "Geller", true);
        Tom.addChild(Fred);
        Tom.addChild(Vanya);
        Fred.addChild(Katya);
        Fred.addChild(Nastya);
        Vanya.addChild(Lora);
        Vanya.addChild(Masha);
        FamilyTree myFamilyTree = new FamilyTree(Tom);
        System.out.println(myFamilyTree.toString());
    }
}