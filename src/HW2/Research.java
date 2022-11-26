package HW2;

import java.util.List;

public class Research {
    public static void getDogLovers(PersonTree persons) {
        List<Person> tree = persons.getTree();
        System.out.println("List of Dog Lovers:");
        for (Person person :
                tree) {
            if (person instanceof DogLover) {
                System.out.println(person);
            }
        }
        System.out.println();
    }

    public static void getCatLovers(PersonTree persons) {
        List<Person> tree = persons.getTree();
        System.out.println("List of Cat Lovers:");
        for (Person person :
                tree) {
            if (person instanceof CatLover) {
                System.out.println(person);
            }
        }
        System.out.println();
    }

    public static void getCats(PetTree pets) {
        List<Pet> tree = pets.getTree();
        System.out.println("List of Cats:");
        for (Pet pet :
                tree) {
            if (pet instanceof Cat) {
                System.out.println(pet);
            }
        }
        System.out.println();
    }

    public static void getDogs(PetTree pets) {
        List<Pet> tree = pets.getTree();
        System.out.println("List of Dogs:");
        for (Pet pet :
                tree) {
            if (pet instanceof Dog) {
                System.out.println(pet);
            }
        }
        System.out.println();
    }

    public static void getAllCall(PersonTree persons, PetTree pets) {
        List<Person> peoples = persons.getTree();
        List<Pet> animals = pets.getTree();
        for (Person person : peoples) {
            for (Pet pet : animals) {
                if (person instanceof DogLover) {
                    ((DogLover) person).callPet(pet);
                } else if (person instanceof CatLover) {
                    ((CatLover) person).callPet(pet);
                }
                System.out.println();
            }
        }
    }

}
