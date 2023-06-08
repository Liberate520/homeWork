package familyTrees;

import members.Aliens;
import members.Human;

public class FamilyTreesArchive {

    /**
     * trees.FamilyTreesArchive of Rurik dynasty
     */
    public static FamilyTree<Human> ruriks = new FamilyTree<>() {
        {
            addPersonInFamilyTree(new Human("Рюрик", "man", 879));
            addPersonInFamilyTree(new Human("Игорь", "man", 945), "Рюрик", 879);
            addPersonInFamilyTree(new Human("Ольга", "woman", 969));
            addPersonInFamilyTree(new Human("Святослав", "man", 972), "Игорь", 945, "Ольга", 969);
            addPersonInFamilyTree(new Human("Олег", "man", 977), "Святослав", 972);
            addPersonInFamilyTree(new Human("Владимир", "man", 1015), "Святослав", 972);
            addPersonInFamilyTree(new Human("Ярополк", "man", 980), "Святослав", 972);
            addPersonInFamilyTree(new Human("Вышеслав", "man", 1010), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Изяслав", "man", 1001), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Всеслав", "man", 1003), "Изяслав", 1001);
            addPersonInFamilyTree(new Human("Брячислав", "man", 1044), "Изяслав", 1001);
            addPersonInFamilyTree(new Human("Всеслав", "man", 1101), "Брячислав", 1044);
            addPersonInFamilyTree(new Human("Святополк", "man", 1019), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Ярослав", "man", 1054), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Илья", "man", 1020), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Владимир", "man", 1020), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Изяслав", "man", 1024), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Святослав", "man", 1027), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Всеволод", "man", 1030), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Вячеслав", "man", 1036), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Борис", "man", 1078), "Вячеслав", 1036);
            addPersonInFamilyTree(new Human("Игорь", "man", 1060), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Давыд", "man", 1060), "Игорь", 1060);
            addPersonInFamilyTree(new Human("Всеволод", "man", 995), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Святослав", "man", 1015), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Мстислав", "man", 1036), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Судислав", "man", 1063), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Борис", "man", 1015), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Глеб", "man", 1015), "Владимир", 1015);
        }
    };

    public static FamilyTree<Aliens> skywalkers = new FamilyTree<>() {
        {
            addPersonInFamilyTree(new Aliens("Shmi", "Skywalker", "woman", -72));
            addPersonInFamilyTree(new Aliens("Anakin", "Skywalker", "man", -42), "Shmi", -72);
            addPersonInFamilyTree(new Aliens("Padme", "Amidala", "woman", -46));
            addPersonInFamilyTree(new Aliens("Luke", "Skywalker", "man", -19), "Anakin", -42, "Padme", -46);
            addPersonInFamilyTree(new Aliens("Leia", "Solo", "woman", -19), "Anakin", -42, "Padme", -46);
            addPersonInFamilyTree(new Aliens("Mara", "Skywalker", "woman", -18));
            addPersonInFamilyTree(new Aliens("Ben", "Skywalker", "man", 26), "Luke", -19, "Mara", -18);
        }
    };

}

