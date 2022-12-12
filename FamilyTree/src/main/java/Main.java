public class Main {
    public static void main(String[] args) {
        var nataly = new Person("Наталья");
        var misha = new Person("Михаил");
        var denis = new Person("Дэнис");
        var lena = new Person("Елена");
        var alex = new Person("Алексей");

        GeoTree gt = new GeoTree();

        gt.append(nataly, Link.parent, Link.child, misha);
        gt.append(nataly, Link.sister, Link.brother, denis);
        gt.append(nataly, Link.sister, Link.brother, alex);
        gt.append(nataly, Link.sister, Link.sister, lena);

        Search search = new Search();

        System.out.println();
        System.out.println("Все сестры и братья Натальи:");
        System.out.println(search.spend(nataly, Link.sister));
        System.out.println();
        System.out.println("Все дети Натальи");
        System.out.println(search.spend(nataly, Link.parent));

    }
}