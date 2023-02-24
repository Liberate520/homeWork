public class Main {
    public static void main(String[] args) {
        Human Alex = new Human(true, "Alex", "муж", 18);
        System.out.println(Alex);
        System.out.println(Alex.getChildren());
        IO data = new IO();
        data.save("test.data", Alex);
        System.out.print("Загрузка: ");
        System.out.println(data.load("test.data"));

    }
}
