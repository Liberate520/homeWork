public class main {
    public static void main(String[] args) {
        Human person1 = new Human("ivan", "pertrov", null, null);
        Human person2 = new Human("olesy", "petrova", null, null);
        Human person3 = new Human("olga", "petrov", person2, person1);
        Human person4 = new Human("Igor", "Nikolaev", null, null);
        Human person5 = new Human("Dmitry", "Nikolaev", person3, person4);
        FamilyThree.addHuman(person1);
        FamilyThree.addHuman(person2);
        FamilyThree.addHuman(person3);
        FamilyThree.addHuman(person4);
        FamilyThree.addHuman(person5);
        System.out.println(person1.getChildren());
        System.out.println(person3.getParents());
        System.out.println(person3.getChildren());
        System.out.println(person5.getParents());



    }
}
