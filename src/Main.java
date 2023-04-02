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
        FamilyTree myFamilyTree1 = new FamilyTree(Tom);
        FamilyTree myFamilyTree2 = new FamilyTree(Vanya);
        //myFamilyTree.save(Writable );
        System.out.println(myFamilyTree1.toString());
        System.out.println(myFamilyTree2.toString());
    }
}