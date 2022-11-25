package Tree;

public class Main {
    public static  void main(String[] args) {
        Tree tree = new Tree();
        Human father = new Human("Сергей","Сопов","14/02/1982",Gender.Male);
        Human mother = new Human("Ольга","Бейзель","07/08/1984",Gender.Female);
        Human son = new Human("Алексей","Сопов","12/07/2005",Gender.Male);
        Human daughter = new Human("Наталья","Сопова","14/05/2019",Gender.Female);
        Human stepson = new Human("Евгений","Гайдамака","22/10/2003",Gender.Male);
        Human sister = new Human("Юлия", "Сопова", "24/04/1989",Gender.Female); 
        
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


        System.out.println("==================================================\n");
        Research.getRelation(father,tree);
        System.out.println("==================================================\n");
        Research.getRelation(mother,tree);
        System.out.println("==================================================\n");
        Research.getRelation(son,tree);
        System.out.println("==================================================\n");
        Research.getRelation(daughter,tree);
        System.out.println("==================================================\n");
        Research.getRelation(stepson,tree);
        System.out.println("==================================================\n");
        Research.getRelation(sister,tree);
        System.out.println("==================================================\n");
    }
}
