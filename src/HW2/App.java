//Описать логику взаимодействия человека и домашнего питомца. Добавить разных животных.
// Добавить разные методы взаимодействия питомца и человека.
// Возможно добавить разных членов семьи?
// Нужно использовать абстрактные классы и интерфейсы.
//
//        Сценарий: Человек “зовёт” котика “кис-кис”, котик отзывается.

package HW2;




public class App {
    /**
     * Тело программы.
     *  В нем созданы несколько личностей, назначены им родственные связи и приведен вызов функций исследования.
     */
    public static void main(String[] args) {
        PersonTree<Person> peoples = new PersonTree<>();
        peoples.add(new DogLover("Gikramin Artur Maratovich", 28));
        peoples.add(new CatLover("Dytlova Tatiana Alexandrovna", 19));
        peoples.add(new CatLover("Gikramina Nailiy Maratovna", 25));
        peoples.add(new DogLover("Gikramina Mira Arturovna", 1));

        Tree tree = new Tree();
        Person pa = new Person("Gikramin Artur Maratovich", 28);
        Person ma = new Person("Gikramina Nailiy Maratovna", 25);
        Person si = new Person( "Dytlova Tatiana Alexandrovna",19);
        Person dot = new Person("Gikramina Mira Arturovna", 1);

        tree.addLink(pa,ma, Relations.HUSBAND, Relations.WIFE);
        tree.addLink(pa,dot, Relations.FATHER, Relations.DAUGHTER);
        tree.addLink(ma,si, Relations.SISTER, Relations.SISTER);
        tree.addLink(ma,dot, Relations.MOTHER, Relations.DAUGHTER);
        tree.addLink(si,dot, Relations.AUNT, Relations.NIECE);

        System.out.println("List of persons:\n" + peoples + "\n");

        PetTree<Pet> pets = new PetTree<>();
        pets.add(new Cat("Selivestor",14));
        pets.add(new Cat("Timon",2));
        pets.add(new Dog("Baron",15));
        pets.add(new Dog("Rada",6));

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
        Research.getResearch(si,tree);
        System.out.println("-------------------\n");

    }
}