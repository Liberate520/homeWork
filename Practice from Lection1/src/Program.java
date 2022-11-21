public class Program {
    public static void main(String[] args) {

        // #region ex1 Demo

        Healer hero2 = new Healer();

        Magician hero3 = new Magician();

        Priest hero4 = new Priest();

        // #endregion

        // #region ex2 Attack
        System.out.println("INFO");
        System.out.println(hero2.getInfo());
        System.out.println(hero3.getInfo());
        System.out.println(hero4.getInfo());
        System.out.println("Attack");

        while (hero3.hp != 0) { // убиваем
            hero4.Attack(hero3);
            hero3.Attack(hero4);
            System.out.println(hero4.getInfo());
            System.out.println(hero3.getInfo());
        }


        System.out.println("Heal");
        hero2.heal(hero4); // пытаемся пролечить
        System.out.println(hero4.getInfo());
        System.out.println(hero2.getInfo());

        System.out.println("It`s Alive!"); // оживляем
        hero2.necromance(hero3);
        System.out.println(hero3.getInfo());
        System.out.println(hero2.getInfo());

        // #endregion

        // #region Teams

//        int teamCount = 10;
//        Random rand = new Random();
//        int magicianCount = 0;
//        int priestCount = 0;
//        int healerCount = 0;
//
//        List<BaseHero> teams = new ArrayList<>();
//        for (int i = 0; i < teamCount; i++) {
//            if (rand.nextInt(3) == 0) {
//                teams.add(new Priest());
//                priestCount++;
//            } else if (rand.nextInt(2) == 1) {
//                teams.add(new Magician());
//                magicianCount++;
//            } else {
//                teams.add(new Healer());
//                healerCount++;
//            }
//
//            System.out.println(teams.get(i).getInfo());
//        }
//        System.out.println();
//        System.out.printf("magicalCount: %d priestCount: %d healerCount: %d \n\n", magicianCount,
//                priestCount, healerCount);

        // attack

        // #endregion

        // todo добавить ещё один класс и
        // реализовать возможность лечения героев
    }
}