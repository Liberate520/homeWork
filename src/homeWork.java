/**
 * homeWork
 */
public class homeWork {

    public static void main(String[] args) {
        
        // конструктор 
        human father1 = new human("Nick");
        //System.out.printf("%s %s\n", father1.getName(), father1.getState());
        
        father1.getKids("Andrew");
        father1.getGrandParents("Michael");
        father1.getGrandParents("Olga");
        father1.getParents("Kris");

        System.out.println("----kids----");
        father1.setKids();
        System.out.println("----grandparents----");
        father1.setGrandParents();
        System.out.println("----parents----");
        father1.setParents();
        System.out.println(father1.getName());
    }
}