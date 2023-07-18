package familyTree.src.family_tree;

import familyTree.src.family_tree.model.human.Gender;
import familyTree.src.family_tree.model.human.Human;
import familyTree.src.family_tree.model.service.Service;

import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {

        Service service = new Service();

        service.addHuman("45№608202", "Мария", Gender.Female, LocalDate.of(1965, 9, 15),,,, "45№705202"));
        service.addHuman("45№705202", "Василий", Gender.Male, LocalDate.of(1963, 12, 10),,,, "45№608202"));
        service.addHuman("18№752-01", "Кристина", Gender.Female, LocalDate.of(1988, 7, 5),,
                (Human) tree.getByDocId("45№705202"), (Human) tree.getByDocId("45№608202")),);
        service.addHuman("18№144-03", "Семен", Gender.Male, LocalDate.of(1991, 1, 25),,
                (Human) tree.getByDocId("45№705202"), (Human) tree.getByDocId("45№608202")),);
        System.out.println(service.getHumanInfo());
        service.sortByBirthDate();
        System.out.println(service.getHumanInfo());
        service.sortByName();
        System.out.println(service.getHumanInfo());
    }
}
//        FamilyTree tree = new FamilyTree();
//
//        tree.add(new Human("45№608202", "Мария", Gender.Female, LocalDate.of(1965, 9, 15), "45№705202"));
//        tree.add(new Human("45№705202", "Василий", Gender.Male, LocalDate.of(1963, 12, 10), "45№608202"));
//        tree.add(new Human("18№752-01", "Кристина", Gender.Female, LocalDate.of(1988, 7, 5),
//                (Human) tree.getByDocId("45№705202"), (Human) tree.getByDocId("45№608202")));
//        tree.add(new Human("18№144-03", "Семен", Gender.Male, LocalDate.of(1991, 1, 25),
//                (Human) tree.getByDocId("45№705202"), (Human) tree.getByDocId("45№608202")));

//        System.out.println(tree.getInfo());
//        String path = "src/familyTree/atree.out";
//        tree.sortByName();
//        System.out.println(tree);
//        tree.sortByBirthDate();
//        System.out.println(tree);


//        FileGeneration fileGeneration = new FileGeneration();
//        fileGeneration.save(tree, path);

//        FileGeneration fileGeneration = new FileGeneration();
//        FamilyTree atree = (FamilyTree) fileGeneration.read(path);
//        System.out.println(tree);
//    }
//}

//    Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм
//    Реализовать, с учетом ооп подхода, приложение.
//    Для проведения исследований с генеалогическим древом.
//    Идея: описать некоторое количество компонент, например:
//    модель человека и дерева
//    Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
//    Более детальное описание проекта и как его реализовать обсуждали в конце семинара
//    Сделать PR к проекту: https://github.com/Liberate520/homeWork
//    В качестве ответа указать ссылку на PR
//    Ссылка на то как сделать пулреквест смотри в материалах к уроку
//    Если PR все таки не дается, то можно и ссылкой на гит репозиторий
//Урок 2. Принципы ООП Абстракция и интерфейсы. Пример проектирования В проекте с гениалогическим древом
// подумайте и используйте интерфейсы.
// Дополнить проект методами записи в файл и чтения из файла. Для этого создать отдельный класс и
// реализовать в нем нужные методы. Для данного класса сделайте интерфейс, который и используйте в
// своей программе. Пример работы с интерфейсом Serialazable можно найти в материалах к уроку.
// Поправить замечания к первому уроку
//Урок 3. Некоторые стандартные интерфейсы Java и примеры их использования
//        Продолжаем работать с проектом с семейным деревом.
//        Реализовать интерфейс Iterable для дерева.
//        Создать методы сортировки списка людей перед выводом, например по имени или по дате рождения (не менее 2)
//        Создать пакетную структуру для проекта
//Урок 4. ООП: Обобщения. ч1
//        Продолжаем грейдить наш проект с генеалогическим древом. Изменить древо, сделать класс
//        параметизированным, чтобы условно дерево можно было использовать не только для людей, но и
//        сделать родословную для собак(класс собак создавать не надо или создать, но в за пределами
//        пакета проекта). Продумать(только подумать, но можно и попробовать реализовать) класс общения
//        с пользователем, набор команд, для операций над деревом
//Урок 5. От простого к практике
//        Реализовать паттерн MVP в вашем проекте с семейным деревом. Примеры проектов смотри на 4 и 5 семинаре