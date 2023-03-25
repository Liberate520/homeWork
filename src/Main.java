import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        GeoTree geo = new GeoTree();
        Person irina = new Person("Ирина", new GregorianCalendar(1985, 01, 13), Gender.Female);
        Person igor = new Person("Игорь", new GregorianCalendar(1984, 10, 25),Gender.Male);
        Person vasya = new Person("Вася", new GregorianCalendar(2001, 03, 17),Gender.Male);
        Person masha = new Person("Маша", new GregorianCalendar(1997, 05, 20),Gender.Female);
        geo.addPerson(irina);
        geo.addPerson(igor);
        geo.addPerson(vasya);
        geo.addPerson(masha);
        vasya.addRelation(irina, Relation.Mother);
        vasya.addRelation(igor, Relation.Father);
        vasya.addRelation(masha, Relation.Sister);
        masha.addRelation(irina, Relation.Mother);
        masha.addRelation(igor, Relation.Father);
        masha.addRelation(vasya, Relation.Brother);
        igor.addRelation(vasya,Relation.Son);
        igor.addRelation(masha, Relation.Daughter);
        igor.addRelation(irina, Relation.Wife);
        irina.addRelation(vasya, Relation.Son);
        irina.addRelation(masha, Relation.Daughter);
        irina.addRelation(igor, Relation.Husband);
        System.out.println(irina.getAge());
        System.out.println(igor.getAge());
        System.out.println(vasya.getAge());
        System.out.println(masha.getAge());
        geo.searchPerson(igor);
        geo.searchPerson(irina);
        geo.searchPerson(vasya);
        geo.searchPerson(masha);
    }
}
