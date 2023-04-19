
public class Main {
        public static void main(String[] args) {
                Human human1 = new Human("Адам", "Петров", "", Gender.МУЖСКОЙ);
                System.out.println(human1.GetShortHumanInfo());
                Human human2 = new Human("Ева", "Гаврилова", "", Gender.ЖЕНСКИЙ);
                Human human3 = new Human("Сергей", "Максимов", "", Gender.МУЖСКОЙ);
                Human human4 = new Human("Вероника", "Ильина", "", Gender.ЖЕНСКИЙ);
                Human human5 = new Human("Андрей", "Петров", "Адамович", human2, human1, Gender.МУЖСКОЙ);
                Human human6 = new Human("Вера", "Максимова", "Сергеевна", human4, human3,
                                Gender.ЖЕНСКИЙ);
                Human human7 = new Human("Лариса", "Иванова", "Вадимовна", human4, human3,
                                Gender.ЖЕНСКИЙ);
                Human human8 = new Human("Ольга", "Кот", "Игоревна", human7, null,
                                Gender.ЖЕНСКИЙ);
                Human human9 = new Human("Мария", "Кот", "Игоревна", human7, human5,
                                Gender.ЖЕНСКИЙ);
                Tree tree = new Tree();
                tree.AddHuman(human1);
                tree.AddHuman(human2);
                tree.AddHuman(human3);
                tree.AddHuman(human4);
                tree.AddHuman(human5);
                tree.AddHuman(human6);
                tree.RemoveHuman(human6);
                tree.ShowFullTreeInfo();

                System.out.println("----------------");

                tree.AddHuman(human6);
                tree.ShowFullTreeInfo();
                System.out.println("----------------");
                tree.AddHuman(human7);
                tree.AddHuman(human8);
                tree.ShowFullTreeInfo();
                tree.ShowShortTreeInfo();
                // System.out.println(tree.GetHumanByFullName("Петров Андрей Адамович"));
                // tree.AddHuman(human9);
                tree.ShowChildrensInfo(human9);
                tree.RemoveHuman(human7);
                tree.ShowFullTreeInfo();
                tree.AddHuman(human7);
                tree.ShowFullTreeInfo();
                tree.ShowGenderStatistics(Gender.МУЖСКОЙ);
                tree.ShowGrandmotherInfo("Кот Ольга Игоревна");
                tree.ShowGrandmotherInfo("Иванова Лариса Вадимовна");
                tree.ShowGrandfatherInfo("Петров Андрей Адамович");
                

        }
}
