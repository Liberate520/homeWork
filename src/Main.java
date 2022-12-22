public class Main {
    public static void main(String[] args) {
        Human a = new Human("Беляева", "Мария", "Александровна", Gender.WOMAN);
        Human b = new Human("Беляев", "Владимир", "Кириллович", Gender.MAN);
        Human c = new Human("Беляев", "Юрий", "Владмирович", Gender.MAN);
        c.setParentFather(b);
        c.setParentMother(a);

        System.out.println(c.toString());
        System.out.println();
        System.out.println(a.toString());
        System.out.println();
        System.out.println(b.toString());
    }
}
