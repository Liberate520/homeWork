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

        //System.out.println(c.toString());

        String uuid = c.getUuid();
        System.out.println(uuid);
        
        Human human = humanList.getHumanByUuid(uuid);
        

        System.out.println(human.toString());

        //System.out.println(c.getUuid());
        //System.out.println(a.toString());
        //System.out.println();
        //System.out.println(b.toString());
    }
}
