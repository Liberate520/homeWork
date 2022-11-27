package Tree1;

import java.util.List;



public class Research {
    /**
     * Класс имеющий методы исследования.
     * — Вывод всех кошатников,
     * — Вывод всех собачников,
     * — Вывод всех кошек,
     * — Вывод всех собак,
     * — Обеспечить позыв всех животных каждым человеком.
     */

    public static void getResearch(Relations relation, Person person, Tree tree) {
        for (Communications el : tree.getLinks()) {
            if (el.getPeople().getName().equals(person.getName())  &&
                    el.getPeople().getName().equals(person.getName())
                    && el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }


    public static void getResearch(Relations relation, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getRelationType() == relation) {
                System.out.println(el);
            }
        }
    }

    public static void getResearch(Person person, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getPeople().getName().equals(person.getName())) {
                System.out.println(el);
            }
        }
    }
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

