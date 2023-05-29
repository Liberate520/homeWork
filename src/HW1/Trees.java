package HW1;

public class Trees {

    /**
     * Trees of Rurik dynasty
     */
    public static FamilyTree ruriks = new FamilyTree() {
        {
            addPersonInFamilyTree(new Human("Рюрик", "man",879));
            addPersonInFamilyTree(new Human("Игорь", "man", 945), "Рюрик");
            addPersonInFamilyTree(new Human("Ольга", "woman", 969));
            addPersonInFamilyTree(new Human("Святослав", "man", 972), "Игорь", "Ольга");
            addPersonInFamilyTree(new Human("Олег", "man", 977), "Святослав");
            addPersonInFamilyTree(new Human("Владимир", "man", 1015), "Святослав");
            addPersonInFamilyTree(new Human("Ярополк", "man", 980), "Святослав");
            addPersonInFamilyTree(new Human("Вышеслав", "man", 1010), "Владимир");
            addPersonInFamilyTree(new Human("Изяслав", "man", 1001), "Владимир");
            addPersonInFamilyTree(new Human("Всеслав", "man", 1003), "Изяслав");
            addPersonInFamilyTree(new Human("Брячислав", "man", 1044), "Изяслав");
            addPersonInFamilyTree(new Human("Всеслав", "man", 1101), "Брячислав");
            addPersonInFamilyTree(new Human("Святополк", "man", 1019), "Владимир");
            addPersonInFamilyTree(new Human("Ярослав", "man", 1054), "Владимир");
            addPersonInFamilyTree(new Human("Илья", "man", 1020), "Ярослав");
            addPersonInFamilyTree(new Human("Владимир", "man", 1020), "Ярослав");
            addPersonInFamilyTree(new Human("Изяслав", "man", 1024), "Ярослав");
            addPersonInFamilyTree(new Human("Святослав", "man", 1027), "Ярослав");
            addPersonInFamilyTree(new Human("Всеволод", "man", 1030), "Ярослав");
            addPersonInFamilyTree(new Human("Вячеслав", "man", 1036), "Ярослав");
            addPersonInFamilyTree(new Human("Борис", "man", 1078), "Вячеслав");
            addPersonInFamilyTree(new Human("Игорь", "man", 1060), "Ярослав");
            addPersonInFamilyTree(new Human("Давыд", "man", 1060), "Игорь");
            addPersonInFamilyTree(new Human("Всеволод", "man", 995), "Владимир");
            addPersonInFamilyTree(new Human("Святослав", "man", 1015), "Владимир");
            addPersonInFamilyTree(new Human("Мстислав", "man", 1036), "Владимир");
            addPersonInFamilyTree(new Human("Судислав", "man", 1063), "Владимир");
            addPersonInFamilyTree(new Human("Борис", "man", 1015), "Владимир");
            addPersonInFamilyTree(new Human("Глеб", "man", 1015), "Владимир");
        }
    };
}
