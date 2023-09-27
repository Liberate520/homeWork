public class Main {
    public static void main(String[] args) {
        GenerationMain бабушкаСмит = new GenerationMain("Смит", "Лидия", "15.06.1945", "25.05.2010", Gender.FEMALE);
        GenerationMain дедушкаСмит = new GenerationMain("Смит", "Роберт", "10.07.1942", Gender.MALE);
        GenerationMain бабушкаДжонсон = new GenerationMain("Джонсон", "Сюзан", "14.04.1949", "15.07.2011", Gender.FEMALE);
        GenerationMain дедушкаДжонсон = new GenerationMain("Джонсон", "Майкл", "12.02.1940", Gender.MALE);

        Human мамаУильямс = new Human("Уильямс", "Екатерина", "20.03.1975", Gender.FEMALE);
        Human папаУильямс = new Human("Уильямс", "Александр", "22.06.1972", Gender.MALE);

        YngGeneration дочьЕмилия = new YngGeneration("Уильямс", "Емилия", "05.05.2005", Gender.FEMALE);
        YngGeneration сынЯков = new YngGeneration("Уильямс", "Яков", "18.09.2007", Gender.MALE);

        YngGeneration дочьЛюдмила = new YngGeneration("Уильямс", "Людмила", "10.10.2010", Gender.FEMALE);

        мамаУильямс.addParent(бабушкаСмит);
        мамаУильямс.addParent(дедушкаСмит);
        папаУильямс.addParent(бабушкаДжонсон);
        папаУильямс.addParent(дедушкаДжонсон);

        дочьЕмилия.addParent(мамаУильямс);
        дочьЕмилия.addParent(папаУильямс);
        сынЯков.addParent(мамаУильямс);
        сынЯков.addParent(папаУильямс);
        дочьЛюдмила.addParent(мамаУильямс);
        дочьЛюдмила.addParent(папаУильямс);

        бабушкаСмит.addChild(мамаУильямс);
        дедушкаСмит.addChild(мамаУильямс);
        бабушкаДжонсон.addChild(папаУильямс);
        дедушкаДжонсон.addChild(папаУильямс);

        мамаУильямс.addChild(дочьЕмилия);
        мамаУильямс.addChild(сынЯков);
        мамаУильямс.addChild(дочьЛюдмила);
        папаУильямс.addChild(дочьЕмилия);
        папаУильямс.addChild(сынЯков);
        папаУильямс.addChild(дочьЛюдмила);

        FamilyTree семейноеДрево = new FamilyTree(бабушкаСмит);
        Human корень = семейноеДрево.getRoot();
        System.out.println("Человек: ");
        System.out.println(корень);
        System.out.println("Дети: ");
        корень.printChildrens();
        System.out.println("Родители:");
        корень.printParents();

        System.out.println("Старшее поколение:");
        for(Human человек: дочьЛюдмила.getMainGen()) {
            System.out.println(человек);
        }

        System.out.println("Младшее поколение:");
        for(Human человек: бабушкаСмит.getYngGen()) {
            System.out.println(человек);
        }
    }
}
