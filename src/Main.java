import java.util.GregorianCalendar;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Person irina = new Person("Ирина", new GregorianCalendar(1985, 01, 13), Gender.Female);
        Person igor = new Person("Игорь", new GregorianCalendar(1984, 10, 25),Gender.Male);
        Person vasya = new Person("Вася", new GregorianCalendar(2001, 03, 17),Gender.Male);
        Person masha = new Person("Маша", new GregorianCalendar(1997, 05, 20),Gender.Female);
        GeoTree gt = new GeoTree();
        gt.appendParentChild(irina, vasya);
        gt.appendParentChild(irina, masha);
        gt.appendParentChild(igor, masha);
        gt.appendParentChild(igor, vasya);
        gt.appendWifeHusband(irina, igor);
        gt.appendBrotherSister(masha, vasya);

        System.out.println("Дети Ирины");
        System.out.println(new Research(gt).spend(irina, Relation.Mother));

        System.out.println("Родители Маши");
        System.out.println(new Research(gt).spend(masha, Relation.Daughter));

        System.out.println("Дети Игоря");
        System.out.println(new Research(gt).spend(igor, Relation.Father));

        System.out.println("Брат Маши");
        System.out.println(new Research(gt).spend(masha, Relation.Sister));

        System.out.println("Муж Ирины");
        System.out.println(new Research(gt).spend(irina, Relation.Wife));

        System.out.println(new Research(gt).searchAge());
        GeoTreeIO io = new GeoTreeIO();
        gt.save(io);
        System.out.println(gt.restore(io));
    }
}