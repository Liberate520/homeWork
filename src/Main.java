import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human a = new Human("Беляева", "Мария", "Александровна", Gender.WOMAN);
        Human b = new Human("Беляев", "Владимир", "Кириллович", Gender.MAN);
        Human c = new Human("Беляев", "Юрий", "Владмирович", Gender.MAN);
        c.setParentFather(b);
        c.setParentMother(a);

        FamilyTree humanList = new FamilyTree();

        humanList.addHuman(a);
        humanList.addHuman(b);
        humanList.addHuman(c);

        String uuid = c.getUuid();
        System.out.println(uuid);

        Human human = humanList.getHumanByUuid(uuid);

        System.out.println(human.toString());
        
        List<Human> humans = humanList.serchHumanByFio("Беляев");

        if (humans.size() > 0) {
            System.out.println("\nРезультат поиска:");
            for (Human h : humans) {
                System.out.println(h.getFIOtoString());
            }
        }
    }
}
