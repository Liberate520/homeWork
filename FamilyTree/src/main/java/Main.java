import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var nataly = new Person("Наталья", 1);
        var misha = new Person("Михаил", 2);
        var denis = new Person("Дэнис", 3);
        var lena = new Person("Елена", 4);
        var alex = new Person("Алексей", 5);

        GeoTree gt = new GeoTree();

        gt.append(nataly, Link.parent, Link.child, misha);
        gt.append(nataly, Link.sister, Link.brother, denis);
        gt.append(nataly, Link.sister, Link.brother, alex);
        gt.append(nataly, Link.sister, Link.sister, lena);

        ArrayList<Person> list = new ArrayList<>();

        list.add(nataly);
        list.add(misha);
        list.add(denis);
        list.add(lena);
        list.add(alex);

        App s = new App();
        s.start(list);

    }
}