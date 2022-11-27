package Tree;

public class App {
    
    public static void main(String[] args) {
        PersonTree peoples = new PersonTree();
        peoples.add(new DogLover("Сопов Сергей Николаевич", 40));
        peoples.add(new CatLover("Сопов Алексей Николаевич", 17));
        peoples.add(new CatLover("Сопова Юлия Николаевна", 33));
        peoples.add(new DogLover("Бейзель Ольга Владимировна", 38));
        peoples.add(new DogLover("Гайдамака Евгений Романович", 19));

        Tree tree = new Tree();
        Human father = new Human("Сопов Сергей Николаевич", 40);
        Human mother = new Human("Бейзель Ольга Владимировна", 38);
        Human sister = new Human( "Сопова Юлия Николаевна",33);
        Human daughter = new Human("Сопова Наталья Николаевна", 3);
        Human son = new Human("Сопов Алексей Николаевич", 17);
        Human stepson = new Human("Гайдамака Евгений Романович", 19);

        tree.addLink(father,sister,Relations.брат,Relations.сестра);
        tree.addLink(father,mother,Relations.муж,Relations.жена);
        tree.addLink(father,son,Relations.отец,Relations.сын);
        tree.addLink(father,daughter,Relations.отец,Relations.дочь);
        tree.addLink(father,stepson,Relations.отчим,Relations.пасынок);

        tree.addLink(mother,son,Relations.мать,Relations.сын);
        tree.addLink(mother,daughter,Relations.мать,Relations.дочь);
        tree.addLink(mother,stepson,Relations.мать,Relations.сын);

        tree.addLink(son,daughter,Relations.брат,Relations.сестра);
        tree.addLink(son,stepson,Relations.брат,Relations.брат);

        tree.addLink(daughter,stepson,Relations.сестра,Relations.брат);

        System.out.println("Люди:\n" + peoples + "\n");

        PetTree pets = new PetTree();
        pets.add(new Cat("Фердинанд",14));
        pets.add(new Cat("Киня",4));
        pets.add(new Dog("Ингрит",10));
        pets.add(new Dog("Гектор",2));
        pets.add(new Dog("Цезарь",11));

        System.out.println("Домашние животные:\n" + pets + "\n");
        System.out.println("=================================================================\n");
        Research.getAllCall(peoples,pets);
        System.out.println("=================================================================\n");
        Research.getCats(pets);
        System.out.println("=================================================================\n");
        Research.getDogs(pets);
        System.out.println("=================================================================\n");
        Research.getCatLovers(peoples);
        System.out.println("=================================================================\n");
        Research.getDogLovers(peoples);



        System.out.println("=================================================================\n");
        Research.getResearch(father,tree);
        System.out.println("=================================================================\n");
        Research.getResearch(mother,tree);
        System.out.println("=================================================================\n");
        Research.getResearch(son,tree);
        System.out.println("=================================================================\n");
        Research.getResearch(daughter,tree);
        System.out.println("=================================================================\n");
        Research.getResearch(stepson,tree);
        System.out.println("=================================================================\n");
        Research.getResearch(sister,tree);
        System.out.println("=================================================================\n");

    }
}    

