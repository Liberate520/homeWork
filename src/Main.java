public class Main {
    public static void main(String[] args) {
        Human a = new Human("Мария", Gender.WOMAN);
        Human b = new Human("Сергей", Gender.MAN);
        Human c = new Human("Юрий", Gender.MAN);
        c.setParentFather(b);
        c.setParentMother(a);

        System.out.println(c.toString());
    }
}
