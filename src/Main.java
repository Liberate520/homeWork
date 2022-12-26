import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human a = new Human("Беляева", "Мария", "Александровна", Gender.WOMAN);
        Human b = new Human("Беляев", "Владимир", "Кириллович", Gender.MAN);
        Human c = new Human("Беляев", "Юрий", "Владмирович", Gender.MAN);
        Human d = new Human("Беляева", "Марина", "Владмировна", Gender.WOMAN);

        a.setSpouse(b);

        c.setParentFather(b);
        c.setParentMother(a);

        d.setParentFather(b);
        d.setParentMother(a);

        Human e = new Human("Зайцева", "Галина", "Васильевна", Gender.WOMAN);
        Human f = new Human("Зйцев", "Николай", "Иванович", Gender.MAN);
        Human g = new Human("Зайцева", "Ирина", "Николаевна", Gender.WOMAN);

        e.setSpouse(f);

        g.setParentFather(f);
        g.setParentMother(e);

        c.setSpouse(g);

        Human h = new Human("Беляева", "Вероника", "Юрьевна", Gender.WOMAN);

        h.setParentFather(g);
        h.setParentMother(c);

        System.out.println(Relationships.getRelationships(c, d));
        System.out.println(Relationships.getRelationships(d, c)); 

        System.out.println(Relationships.getRelationships(e, a));
        System.out.println(Relationships.getRelationships(b, g));

        System.out.println(Relationships.getRelationships(h, a));
        System.out.println(Relationships.getRelationships(b, h));
        
        FamilyTree humanList = new FamilyTree();

        humanList.addHuman(a);
        humanList.addHuman(b);
        humanList.addHuman(c);
        humanList.addHuman(d);
        humanList.addHuman(e);
        humanList.addHuman(f);
        humanList.addHuman(g);
        humanList.addHuman(h);

        String uuid = c.getUuid();
        System.out.println(uuid);

        Human human = humanList.getHumanByUuid(uuid);

        System.out.println(human.toString());
        
        List<Human> humans = humanList.serchHumanByFio("Беляева");

        if (humans.size() > 0) {
            System.out.println("\nРезультат поиска:");
            for (Human hum : humans) {
                System.out.println(hum.getFIOtoString());
            }
        }
    }
}
