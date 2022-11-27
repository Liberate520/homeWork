//Описать логику взаимодействия человека и домашнего питомца. Добавить разных животных.
// Добавить разные методы взаимодействия питомца и человека.
// Возможно добавить разных членов семьи?
// Нужно использовать абстрактные классы и интерфейсы.
//
//        Сценарий: Человек “зовёт” котика “кис-кис”, котик отзывается.

package Tree1;


public class Main {
    public static void main(String[] args) {
        PersonTree peoples = new PersonTree();
        peoples.add(new DogLover("Valetov Vasiliy Innokentievich", 82));
        peoples.add(new CatLover("Voynash Tamara Vasilevna", 56));
        peoples.add(new DogLover("Valetova Elena Petrovna", 79));
        peoples.add(new CatLover("Valetov Andrey Vasilievich", 50));

        Tree tree = new Tree();
        Person pa = new Person("Valetov Vasiliy Innokentievich",82);
        Person ma = new Person("Valetova Elena Petrovna", 79);
        Person so = new Person("Valetov Andrey  Vasilievich", 50);
        Person dot = new Person("Voynash Tamara Vasilevna", 56);

        tree.addLink(pa,ma, Relations.HUSBAND, Relations.WIFE);
        tree.addLink(pa,so, Relations.FATHER, Relations.SON);
        tree.addLink(pa,dot, Relations.FATHER, Relations.DAUGHTER);
        tree.addLink(ma,so, Relations.MOTHER, Relations.SON);
        tree.addLink(ma,dot, Relations.MOTHER, Relations.DAUGHTER);
        tree.addLink(so,dot, Relations.BROTHER, Relations.SISTER);

        System.out.println("List of persons:\n" + peoples + "\n");

        PetTree pets = new PetTree();
        pets.add(new Cat("Nusha",9));
        pets.add(new Cat("Marik",7));
        pets.add(new Dog("Druzok",12));
        pets.add(new Dog("Graf",1));

        System.out.println("List of pets:\n" + pets + "\n");
        System.out.println("-------------------\n");
        Research.getAllCall(peoples,pets);
        System.out.println("-------------------\n");
        Research.getCats(pets);
        System.out.println("-------------------\n");
        Research.getDogs(pets);
        System.out.println("-------------------\n");
        Research.getCatLovers(peoples);
        System.out.println("-------------------\n");
        Research.getDogLovers(peoples);



        System.out.println("-------------------\n");
        System.out.println(tree);
        System.out.println("-------------------\n");
        Research.getResearch(pa,tree);
        System.out.println("-------------------\n");
        Research.getResearch(dot,tree);
        System.out.println("-------------------\n");
        Research.getResearch(so,tree);
        System.out.println("-------------------\n");
        Research.getResearch(Relations.SISTER, tree);
        System.out.println("-------------------\n");
        Research.getResearch(Relations.HUSBAND, pa, tree);
    }
}