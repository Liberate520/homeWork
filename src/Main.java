import people.People;

public class Main {
    public static void main(String[] args) {

        People father = new People("Boris", 47);
        People mather = new People("Marina", 45);
        TreeFamily son = new TreeFamily("Dik", 16, mather, father);
        System.out.print(son);
    }


}
