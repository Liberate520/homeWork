import java.util.ArrayList;
public class pogramm {
    public static void main(String[] args) {

        System.out.println("start");
        ArrayList<Person> base = load_data.load_CVS("base.csv");
        for (Person person : base) {
            System.out.println(person);
        }
        int id = 4;
        print(id, base);
        print(0, base);
        get_child(6, base);
        
        
    }
    public static void print(int id, ArrayList<Person> base) {
        Person person = base.get(id);
        System.out.println("\n Данные на - " + person.getName());
        System.out.println("Имя - " + person.getName() + ",\n родился: ");
        System.out.printf("%d/%d/%d \n", person.getYear(), person.getMonth(), person.getDay());
        if (person.getFather_id() > 0) System.out.println("Отец - " + base.get(person.getFather_id()).getName());
        if (person.getMother_id() > 0)System.out.println("Мать - " + base.get(person.getMother_id()).getName());
        System.out.println("В браке с - " + base.get(person.getPartner()).getName());
    }

    public static void get_child(int id, ArrayList<Person> base) {
        Person person = base.get(id);
        ArrayList<Person> children = new ArrayList<>();
        for (Person person_check : base) {
            if (person_check.getFather_id() == id)
            {
                children.add(person_check);
            }
        }
        System.out.println("\n Список детей " + person.getName());
        for (Person person2 : children) {
            System.out.println(person2.getName());
        }
    }
}
