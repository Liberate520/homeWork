//Описать логику взаимодействия человека и домашнего питомца. Добавить разных животных.
// Добавить разные методы взаимодействия питомца и человека.
// Возможно добавить разных членов семьи?
// Нужно использовать абстрактные классы и интерфейсы.
//
//        Сценарий: Человек “зовёт” котика “кис-кис”, котик отзывается.

package HW2;

public class Main {
    public static void main(String[] args) {
        PersonTree peoples = new PersonTree();
        peoples.add(new DogLover("Sergei", 43));
        peoples.add(new CatLover("Nikolai", 25));
        peoples.add(new DogLover("Tatjana", 37));
        peoples.add(new CatLover("Natali", 23));
        peoples.add(new DogLover("Oleg", 18));
        peoples.add(new CatLover("Mari", 28));

        System.out.println("List of persons:\n" + peoples + "\n");

        PetTree pets = new PetTree();
        pets.add(new Cat("Murzik",3));
        pets.add(new Cat("Barsik",7));
        pets.add(new Dog("Charik",1));
        pets.add(new Dog("Grom",5));

        System.out.println("List of pets:\n" + pets + "\n");

        Research.getAllCall(peoples, pets);
        Research.getCats(pets);
        Research.getDogs(pets);
        Research.getCatLovers(peoples);
        Research.getDogLovers(peoples);
    }
}