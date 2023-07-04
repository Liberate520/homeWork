//Реализовать, с учетом ооп подхода, приложение.
//        Для проведения исследований с генеалогическим древом.
//        Идея: описать некоторое количество компонент, например:
//        модель человека и дерева
//        Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
//        Более детальное описание проекта и как его реализовать обсуждали в конце семинара
//        Сделать PR к проекту: https://github.com/Liberate520/homeWork
//        В качестве ответа указать ссылку на PR
//        Ссылка на то как сделать пулреквест смотри в материалах к уроку
//        Если PR все таки не дается, то можно и ссылкой на гит репозиторий

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Tree familyTree = new Tree();

        Person grandmotherF = new Person("FathersMom", LocalDate.of(1901, 01, 01), LocalDate.of(2000, 01, 01), Gender.Female);
        Person grandmotherM = new Person("MothersMom", LocalDate.of(1900, 01, 01), LocalDate.of(1999, 01, 01), Gender.Female);
        Person grandfatherM = new Person("MothersFather", LocalDate.of(1900, 01, 01), Gender.Male);
        grandmotherM.setPartner(grandfatherM);
        Person motherBrother = new Person("MotherBrother", LocalDate.of(1960, 01, 01), Gender.Male, grandmotherM, grandfatherM);
        Person mother = new Person("Mother", LocalDate.of(1955, 01, 01), Gender.Female, grandmotherM, grandfatherM);
        Person father = new Person("Father", LocalDate.of(1965, 01, 01), Gender.Male, grandmotherF, null);
        mother.setPartner(father);
        Person child1 = new Person("FirstChild", LocalDate.of(2000, 01, 01), Gender.Female, mother, father);
        Person child2 = new Person("SecondChild", LocalDate.of(2001, 01, 01), Gender.Male, mother, father);

        familyTree.add(grandfatherM);
        familyTree.add(grandmotherM);
        familyTree.add(grandmotherF);
        familyTree.add(motherBrother);
        familyTree.add(mother);
        familyTree.add(father);
        familyTree.add(child1);
        familyTree.add(child2);

        familyTree.reviseDependencies();

        System.out.println(familyTree);

    }

}
