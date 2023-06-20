package model.familyTrees;

import model.members.Aliens;
import model.members.Human;
import model.members.Member;

import java.util.ArrayList;
import java.util.List;

import static model.members.Gender.MAN;
import static model.members.Gender.WOMAN;

public class FamilyTreesArchive {

    public List<FamilyTree> familyTreeList = new ArrayList<>(){{
        add(ruriks);
        add(skywalkers);
    }};



    /**
     * trees.FamilyTreesArchive of Rurik dynasty
     */
    public static FamilyTree<Member> ruriks = new FamilyTree<>("Рюриковичи") {
        {
            addPersonInFamilyTree(new Human("Рюрик", MAN, 879));
            addPersonInFamilyTree(new Human("Игорь", MAN, 945), "Рюрик", 879);
            addPersonInFamilyTree(new Human("Ольга", WOMAN, 969));
            addPersonInFamilyTree(new Human("Святослав", MAN, 972), "Игорь", 945, "Ольга", 969);
            addPersonInFamilyTree(new Human("Олег", MAN, 977), "Святослав", 972);
            addPersonInFamilyTree(new Human("Владимир", MAN, 1015), "Святослав", 972);
            addPersonInFamilyTree(new Human("Ярополк", MAN, 980), "Святослав", 972);
            addPersonInFamilyTree(new Human("Вышеслав", MAN, 1010), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Изяслав", MAN, 1001), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Всеслав", MAN, 1003), "Изяслав", 1001);
            addPersonInFamilyTree(new Human("Брячислав", MAN, 1044), "Изяслав", 1001);
            addPersonInFamilyTree(new Human("Всеслав", MAN, 1101), "Брячислав", 1044);
            addPersonInFamilyTree(new Human("Святополк", MAN, 1019), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Ярослав", MAN, 1054), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Илья", MAN, 1020), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Владимир", MAN, 1020), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Изяслав", MAN, 1024), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Святослав", MAN, 1027), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Всеволод", MAN, 1030), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Вячеслав", MAN, 1036), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Борис", MAN, 1078), "Вячеслав", 1036);
            addPersonInFamilyTree(new Human("Игорь", MAN, 1060), "Ярослав", 1054);
            addPersonInFamilyTree(new Human("Давыд", MAN, 1060), "Игорь", 1060);
            addPersonInFamilyTree(new Human("Всеволод", MAN, 995), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Святослав", MAN, 1015), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Мстислав", MAN, 1036), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Судислав", MAN, 1063), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Борис", MAN, 1015), "Владимир", 1015);
            addPersonInFamilyTree(new Human("Глеб", MAN, 1015), "Владимир", 1015);
        }
    };

    public static FamilyTree<Aliens> skywalkers = new FamilyTree<>("Скайвокеры") {
        {
            addPersonInFamilyTree(new Aliens("Shmi", "Skywalker", WOMAN, -72));
            addPersonInFamilyTree(new Aliens("Anakin", "Skywalker", MAN, -42), "Shmi", -72);
            addPersonInFamilyTree(new Aliens("Padme", "Amidala", WOMAN, -46));
            addPersonInFamilyTree(new Aliens("Luke", "Skywalker", MAN, -19), "Anakin", -42, "Padme", -46);
            addPersonInFamilyTree(new Aliens("Leia", "Solo", WOMAN, -19), "Anakin", -42, "Padme", -46);
            addPersonInFamilyTree(new Aliens("Mara", "Skywalker", WOMAN, -18));
            addPersonInFamilyTree(new Aliens("Ben", "Skywalker", MAN, 26), "Luke", -19, "Mara", -18);
        }
    };

}

