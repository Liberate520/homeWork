package Tree;

import java.util.List;

public class Research {    
    public static void getResearch(Relations relation, Human person, Tree tree) {
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

    public static void getResearch(Human person, Tree tree) {
        for (Communications el :
                tree.getLinks()) {
            if (el.getPeople().getName().equals(person.getName())) {
                System.out.println(el);
            }
        }
    }
    public static void getDogLovers(PersonTree persons) {
        List<Human> tree = persons.getTree();
        System.out.println("Любители собак:");
        for (Human person :
                tree) {
            if (person instanceof DogLover) {
                System.out.println(person);
            }
        }
        System.out.println();
    }

    public static void getCatLovers(PersonTree persons) {
        List<Human> tree = persons.getTree();
        System.out.println("Любители котов:");
        for (Human person :
                tree) {
            if (person instanceof CatLover) {
                System.out.println(person);
            }
        }
        System.out.println();
    }

    public static void getCats(PetTree pets) {
        List<Pet> tree = pets.getTree();
        System.out.println("Кошки:");
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
        System.out.println("Собаки:");
        for (Pet pet :
                tree) {
            if (pet instanceof Dog) {
                System.out.println(pet);
            }
        }
        System.out.println();
    }


    public static void getAllCall(PersonTree persons, PetTree pets) {
        List<Human> peoples = persons.getTree();
        List<Pet> animals = pets.getTree();
        for (Human person : peoples) {
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
