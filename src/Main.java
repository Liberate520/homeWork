import java.io.Serializable;

/**
 * Main
 */
public class Main implements Serializable {
    
    public static void main(String[] args) {
        Service service = new Service("family.bin");

        System.out.println("ORIGINAL:");
        System.out.println(service.getInfo());

        System.out.println("--------------------");
        System.out.println("SORTED BY NAME:");
        service.sortFamilyByName();
        System.out.println(service.getInfo());

        System.out.println("--------------------");
        System.out.println("SORTED BY BIRTHDAY:");
        service.sortFamilyByBirthday();
        System.out.println(service.getInfo());

        System.out.println("--------------------");
        System.out.println("SORTED BY CHILDREN AMOUNT:");
        service.sortFamilyByChildrenAmount();
        System.out.println(service.getInfo());      
    }
}