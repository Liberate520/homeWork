package ZOO;

public class Main {
    public static void main(String[] args) {
        CatOwner catOwner = new CatOwner("Alex ", "owner");
        CatOwner catOwner2 = new CatOwner("Zed ", "no owner");
        Cat cat = new Cat(" Tomas");
        Call call = new Call(catOwner, cat);
        call.call();

        System.out.println("\n");
        Call call2 = new Call (catOwner2, cat);
        call2.call();
    }
}
