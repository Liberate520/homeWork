import handler.FileHandler;
import human.Gender;



public class Main {
        public static void main(String[] args) {

                // Human human1 = new Human("Адам", "Петров", Gender.Male, 60);
                // Human human2 = new Human("Ева", "Гаврилова", "", Gender.Female);
                // Human human3 = new Human("Сергей", "Максимов", "", Gender.Male);
                // Human human4 = new Human("Вероника", "Ильина", "", Gender.Female);
                // Human human5 = new Human("Андрей", "Петров", "Адамович", human2, human1,
                // Gender.Male, 25);
                // Human human6 = new Human("Вера", "Максимова", "Сергеевна", human4, human3,
                // Gender.Female, 21);
                // Human human7 = new Human("Лариса", "Иванова", "Вадимовна", human4, human3,
                // Gender.Female, 38);
                // Human human8 = new Human("Ольга", "Кот", "Игоревна", human7, null,
                // Gender.Female, 18);
                // Human human9 = new Human("Мария", "Кот", "Игоревна", human7, human5,
                // Gender.Female, 20);
                // Tree tree = new Tree();
                // tree.addHuman(human1);
                // tree.addHuman(human2);
                // tree.addHuman(human3);
                // tree.addHuman(human4);
                // tree.addHuman(human5);
                // tree.addHuman(human6);
                // tree.removeHuman(human6);
                // tree.showFullTreeInfo();

                // System.out.println("----------------");

                // tree.addHuman(human6);
                // tree.showFullTreeInfo();
                // System.out.println("----------------");
                // tree.addHuman(human7);
                // tree.addHuman(human8);
                // tree.showFullTreeInfo();
                // tree.showShortTreeInfo();

                // tree.showChildrensInfo(human9);
                // tree.removeHuman(human7);
                // tree.showFullTreeInfo();
                // tree.addHuman(human7);
                // tree.showFullTreeInfo();
                // tree.showGenderStatistics(Gender.Male);
                // tree.showGenderStatistics(Gender.Female);
                // tree.showGrandmotherInfo("Кот Ольга Игоревна");
                // tree.showGrandmotherInfo("Иванова Лариса Вадимовна");
                // tree.showGrandfatherInfo("Петров Андрей Адамович");

                // String path = "src/Handler/saveTree.txt";
                // Saveble fileHandler = new FileHandler();
                // fileHandler.save(path, tree);

                // // Tree tree = (Tree) fileHandler.load(path);

                // tree.showFullTreeInfo();
                final String PATH = "src/Handler/saveTree.txt";
                TreeService service = new TreeService(new FileHandler());

                service.addHuman("Адам", "Петров", null, null, null, Gender.Male, 60);
                service.addHuman("Ева", "Гаврилова", null, null, null, Gender.Female, 45);
                service.addHuman("Сергей", "Максимов", null, null, null, Gender.Male, 50);
                service.addHuman("Вероника", "Ильина", null, null, null, Gender.Female, 49);
                service.addHuman("Андрей", "Петров", "Адамович", "Гаврилова Ева", "Петров Адам",
                                Gender.Male, 25);
                service.addHuman("Вера", "Максимова", "Сергеевна", "Ильина Вероника", "Максимов Сергей",
                                Gender.Female, 21);
                service.addHuman("Лариса", "Иванова", "Сергеевна", "Ильина Вероника", "Максимов Сергей",
                                Gender.Female, 38);
                service.addHuman("Ольга", "Кот", null, "Иванова Лариса Сергеевна", null,
                                Gender.Female, 18);
                service.addHuman("Мария", "Кот", "Андреевна", "Иванова Лариса Сергеевна", "Петров Андрей Адамович",
                                Gender.Female, 20);
                service.showShortTreeInfo();
                service.showGenderStatistics(Gender.Male);
                service.showChildrensInfo("Ильина Вероника");
                service.showInfo();
                service.sortBySurName();
                service.showInfo();
                service.sortByAge();
                service.showShortTreeInfo();
                service.sortByChildrens();
                service.showInfo();
                service.showGrandmotherInfo("Кот Ольга");
                service.showGrandmotherInfo("Иванова Лариса Вадимовна");
                service.showGrandfatherInfo("Петров Андрей Адамович");

                // // --------- сохранение данных
                // service.save(PATH,service.getTree());

                // // --------- загрузка сохраненных данных
                // service.load(PATH);
                // service.showInfo();

                // --------- удаление пользователя
                // service.removeHuman("Адам", "Петров","");
                // service.showFullTreeInfo();

        }
}
