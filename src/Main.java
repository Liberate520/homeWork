import java.util.ArrayList;

// Реализовать, с учетом ооп подхода, приложение для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например: модель человека и дерева
// Под “проведением исследования” можно понимать например получение всех детей выбранного человека.

public class Main {
    public static void main(String[] args) {
        // Личные данные (В данном примере - Имя, Год рождения.)
        ArrayList<Person> romanovsMembers = romanovPersons();
        // Добавление родственных связей (В данном примере - супруги и дети)
        ArrayList<Relation> romRelations = romanovRelations(romanovsMembers);

        // Вывод полного списка:
        printAllData(romRelations);

        String exampleName = "Пётр I Алексеевич";
        // Найти родителей по полному имени:
        System.out.println("\nПоиск родителей по полному имени (Пример)." +
                "\nПоиск по имени: \"Пётр I Алексеевич\"");
        printResults(findParents(romRelations, exampleName));

        // Найти всех братьев и сестер:
        System.out.println("\nПоиск всех братьев и сестер по полному имени (Пример)." +
                "\nПоиск по имени: \"Пётр I Алексеевич\"");
        printResults(findSiblings(romRelations, exampleName));

    }

    public static void printAllData(ArrayList<Relation> inputRelations) {
        for (Relation relation : inputRelations) {
            System.out.println(relation + "\n");
        }
    }

    public static void printResults(ArrayList<String> results) {
        if (results.isEmpty()) {
            System.out.println("Совпадений не найдено.");
            return;
        }
        String suffix = "";
        for (int i = 0; i < results.size(); i++) {
            System.out.print(suffix);
            suffix = ", ";
            System.out.print(results.get(i));
        }
        System.out.println();
    }

    public static ArrayList<String> findSiblings(ArrayList<Relation> inputRelations, String personName) {
        ArrayList<String> siblingsList = new ArrayList<>();
        for (Relation relation : inputRelations) {
            for (Person kid : relation.getKidsList()) {
                if (kid.getFullName().equals(personName)) {
                    for (Person siblingPerson : relation.getKidsList()) {
                        if (!(siblingsList.contains(siblingPerson.getFullName())
                                || siblingPerson.getFullName().equals(personName))) {
                            siblingsList.add(siblingPerson.getFullName());
                        }
                    }
                    break;
                }
            }
        }
        return siblingsList;
    }

    public static ArrayList<String> findParents(ArrayList<Relation> inputRelations, String kidName) {
        ArrayList<String> parentsList = new ArrayList<>();
        for (Relation relation : inputRelations) {
            for (Person kid : relation.getKidsList()) {
                if (kid.getFullName().equals(kidName)) {
                    parentsList.add(relation.getFullName());
                }
            }
        }
        return parentsList;
    }

    public static ArrayList<Person> romanovPersons() {
        ArrayList<Person> romanovList = new ArrayList<>();
        romanovList.add(new Person(0, "Михаил Федорович", 1613));
        romanovList.add(new Person(1, "Евдокия Стрешнева", null));
        romanovList.add(new Person(2, "Мария Милославская", null));
        romanovList.add(new Person(3, "Алексей Михайлович", 1645));
        romanovList.add(new Person(4, "Наталья Нарышкина", null));
        romanovList.add(new Person(5, "Федор Алексеевич", 1676));
        romanovList.add(new Person(6, "Софья Алексеевна", 1682));
        romanovList.add(new Person(7, "Евдокия Лопухина", null));
        romanovList.add(new Person(8, "Пётр I Алексеевич", 1682));
        romanovList.add(new Person(9, "Екатерина I Алексеевна", 1725));
        // System.out.println(romanovList);
        return romanovList;
    }

    public static ArrayList<Relation> romanovRelations(ArrayList<Person> romPerson) {
        ArrayList<Relation> romRelation = new ArrayList<>();
        for (Person person : romPerson)
            romRelation.add(new Relation(person));
        romRelation.get(0).addMarriage(romPerson.get(1));
        romRelation.get(0).addKid(romPerson.get(3));

        romRelation.get(1).addMarriage(romPerson.get(0));
        romRelation.get(0).addKid(romPerson.get(3));

        romRelation.get(2).addMarriage(romPerson.get(3));
        romRelation.get(2).addKid(romPerson.get(5));
        romRelation.get(2).addKid(romPerson.get(6));

        romRelation.get(3).addMarriage(romPerson.get(2));
        romRelation.get(3).addKid(romPerson.get(5));
        romRelation.get(3).addKid(romPerson.get(6));
        romRelation.get(3).addMarriage(romPerson.get(4));
        romRelation.get(3).addKid(romPerson.get(7));
        romRelation.get(3).addKid(romPerson.get(8));
        romRelation.get(3).addKid(romPerson.get(9));

        romRelation.get(4).addMarriage(romPerson.get(3));
        romRelation.get(4).addKid(romPerson.get(7));
        romRelation.get(4).addKid(romPerson.get(8));
        romRelation.get(4).addKid(romPerson.get(9));

        romRelation.get(7).addMarriage(romPerson.get(8));

        romRelation.get(8).addMarriage(romPerson.get(7));
        romRelation.get(8).addMarriage(romPerson.get(9));

        romRelation.get(9).addMarriage(romPerson.get(8));
        return romRelation;
    }

}
