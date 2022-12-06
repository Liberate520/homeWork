public class Main {
    public static void main(String[] args) {
        var nataly = new Person("Наталья");
        var misha = new Person("Михаил");
        var denis = new Person("Дэнис");
        var lena = new Person("Елена");
        var alex = new Person("Алексей");

        GeoTree gt = new GeoTree();

        gt.append(nataly, Human.link.parent, Human.link.child, misha);
        gt.append(nataly, Human.link.sister, Human.link.brother, denis);
        gt.append(nataly, Human.link.sister, Human.link.brother, alex);
        gt.append(nataly, Human.link.sister, Human.link.sister, lena);

        System.out.println();
        System.out.println("Все сестры и братья Натальи:");
        System.out.println(new Search(gt).spend(nataly, Human.link.sister));
        System.out.println();
        System.out.println("Все дети Натальи");
        System.out.println(new Search(gt).spend(nataly, Human.link.parent));

    }
}