import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
        public static void main(String[] args) {
                try {
                        Human human1 = new Human("Адам", "Петров", "", Gender.Male);
                        Human human2 = new Human("Ева", "Гаврилова", "", Gender.Female);
                        Human human3 = new Human("Сергей", "Максимов", "", Gender.Male);
                        Human human4 = new Human("Вероника", "Ильина", "", Gender.Female);
                        Human human5 = new Human("Андрей", "Петров", "Адамович", human2, human1,
                                        Gender.Male);
                        Human human6 = new Human("Вера", "Максимова", "Сергеевна", human4, human3,
                                        Gender.Female);
                        Human human7 = new Human("Лариса", "Иванова", "Вадимовна", human4, human3,
                                        Gender.Female);
                        Human human8 = new Human("Ольга", "Кот", "Игоревна", human7, null,
                                        Gender.Female);
                        Human human9 = new Human("Мария", "Кот", "Игоревна", human7, human5,
                                        Gender.Female);
                        Tree tree = new Tree();
                        tree.addHuman(human1);
                        tree.addHuman(human2);
                        tree.addHuman(human3);
                        tree.addHuman(human4);
                        tree.addHuman(human5);
                        tree.addHuman(human6);
                        tree.removeHuman(human6);
                        tree.showFullTreeInfo();

                        System.out.println("----------------");

                        tree.addHuman(human6);
                        tree.showFullTreeInfo();
                        System.out.println("----------------");
                        tree.addHuman(human7);
                        tree.addHuman(human8);
                        tree.showFullTreeInfo();
                        tree.showShortTreeInfo();

                        tree.showChildrensInfo(human9);
                        tree.removeHuman(human7);
                        tree.showFullTreeInfo();
                        tree.addHuman(human7);
                        tree.showFullTreeInfo();
                        tree.showGenderStatistics(Gender.Male);
                        tree.showGenderStatistics(Gender.Female);
                        tree.showGrandmotherInfo("Кот Ольга Игоревна");
                        tree.showGrandmotherInfo("Иванова Лариса Вадимовна");
                        tree.showGrandfatherInfo("Петров Андрей Адамович");

                        String path = "src/saveTree.txt";
                        Saveble fileHandler = new FileHandler();
                        fileHandler.save(path, tree);

                        // Tree tree = (Tree) fileHandler.load(path);

                        tree.showFullTreeInfo();
                } catch (NullPointerException e) {
                        System.out.println("Дерево не может быть null");
                }

        }
}
