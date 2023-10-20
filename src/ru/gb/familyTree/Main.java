package ru.gb.familyTree;

import ru.gb.familyTree.person.Gender;
import ru.gb.familyTree.person.Person;
import ru.gb.familyTree.person.PersonBuilder;
import ru.gb.familyTree.person.PersonSaver;
import ru.gb.familyTree.tree.FamilyTreeBuilder;
import ru.gb.familyTree.tree.FamilyTree;
import ru.gb.familyTree.tree.Node;
import ru.gb.familyTree.tree.NodeBuilder;

import java.time.LocalDate;

public class Main {
        static Node n11 = new NodeBuilder().createNode();
        static Node n21 = new NodeBuilder().createNode();
        static Node n22 = new NodeBuilder().createNode();
        static Node n31 = new NodeBuilder().createNode();
        static Node n32 = new NodeBuilder().createNode();
        static Node n33 = new NodeBuilder().createNode();
        static Node n34 = new NodeBuilder().createNode();
        static Node n41 = new NodeBuilder().createNode();
        static Node n42 = new NodeBuilder().createNode();
        static Node n43 = new NodeBuilder().createNode();
        static Node n44 = new NodeBuilder().createNode();
        static Node n52 = new NodeBuilder().createNode();

    public static void main(String[] args) {
        /**
         * Создание дерева (фрагмент!):
         */
        FamilyTree romanovTree = new FamilyTreeBuilder().setFamily("Романовы").createFamilyTree();
        addPersons();
        addNodes(romanovTree);
    }

    /**
     * Заполнение дерева узлами (браками):
     */
    private static void addNodes(FamilyTree treeName){
        n11.setFamily(treeName);n11.setId(11);//1 ряд 1 место
        n11.setParentOne(PersonSaver.getObjectById(11)); n11.setParentTwo(PersonSaver.getObjectById(12));
        n11.addChildren(PersonSaver.getObjectById(22));
        System.out.println(n11.toString() + "\n");

        n21.setFamily(treeName);n21.setId(21);//2 ряд 1 место
        n21.setParentOne(PersonSaver.getObjectById(21)); n21.setParentTwo(PersonSaver.getObjectById(22));
        n21.addChildren(PersonSaver.getObjectById(32)); n21.addChildren(PersonSaver.getObjectById(33));
        n21.addChildren(PersonSaver.getObjectById(34));
        System.out.println(n21.toString() + "\n");

        n22.setFamily(treeName);n22.setId(22);//2 ряд 2 место
        n22.setParentOne(PersonSaver.getObjectById(22)); n22.setParentTwo(PersonSaver.getObjectById(23));
        n22.addChildren(PersonSaver.getObjectById(37));
        System.out.println(n22.toString() + "\n");

        n31.setFamily(treeName);n31.setId(31);//3 ряд 1 место
        n31.setParentOne(PersonSaver.getObjectById(31)); n31.setParentTwo(PersonSaver.getObjectById(32));
        System.out.println(n31.toString() + "\n");

        n32.setFamily(treeName);n32.setId(32);//3 ряд 2 место
        n32.setParentOne(PersonSaver.getObjectById(34)); n32.setParentTwo(PersonSaver.getObjectById(35));
        n32.addChildren(PersonSaver.getObjectById(42));n32.addChildren(PersonSaver.getObjectById(43));
        System.out.println(n32.toString() + "\n");

        n33.setFamily(treeName);n33.setId(33);//3 ряд 3 место
        n33.setParentOne(PersonSaver.getObjectById(36)); n33.setParentTwo(PersonSaver.getObjectById(37));
        n33.addChildren(PersonSaver.getObjectById(46));
        System.out.println(n33.toString() + "\n");

        n34.setFamily(treeName);n34.setId(34);//3 ряд 4 место
        n34.setParentOne(PersonSaver.getObjectById(37)); n34.setParentTwo(PersonSaver.getObjectById(38));
        n34.addChildren(PersonSaver.getObjectById(48));n34.addChildren(PersonSaver.getObjectById(49));
        System.out.println(n34.toString() + "\n");

        n41.setFamily(treeName);n41.setId(41);//4 ряд 1 место
        n41.setParentOne(PersonSaver.getObjectById(41)); n41.setParentTwo(PersonSaver.getObjectById(42));
        System.out.println(n41.toString() + "\n");

        n42.setFamily(treeName);n42.setId(42);//4 ряд 2 место
        n42.setParentOne(PersonSaver.getObjectById(43)); n42.setParentTwo(PersonSaver.getObjectById(44));
        System.out.println(n42.toString() + "\n");

        n43.setFamily(treeName);n43.setId(43);//4 ряд 3 место
        n43.setParentOne(PersonSaver.getObjectById(45)); n43.setParentTwo(PersonSaver.getObjectById(46));
        System.out.println(n43.toString() + "\n");

        n44.setFamily(treeName);n44.setId(44);//4 ряд 4 место
        n44.setParentOne(PersonSaver.getObjectById(47)); n44.setParentTwo(PersonSaver.getObjectById(48));
        n44.addChildren(PersonSaver.getObjectById(55));
        System.out.println(n44.toString() + "\n");

        n52.setFamily(treeName);n52.setId(52);//5 ряд 2 место
        n52.setParentOne(PersonSaver.getObjectById(54)); n52.setParentTwo(PersonSaver.getObjectById(55));
        System.out.println(n52.toString() + "\n");
    }

    /**
     * Заполнение персон - участников:
     */
    private static void addPersons(){
        Person temp = new PersonBuilder().createPerson();
        temp.setId(11);//1 ряд 1 место
        temp.setGender(Gender.Male); temp.setFirstName("Михаил"); temp.setSecondName("Фёдорович");
        temp.setStartDay(LocalDate.of(1613, 1, 1));
        temp.setStopDay(LocalDate.of(1645, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(11));
        temp.clear();

        temp.setId(12);//1 ряд 2 место
        temp.setGender(Gender.Female); temp.setFirstName("Евдокия"); temp.setSecondName("Лукьяновна");
        temp.setLastName("Стрешнева");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(12));
        temp.clear();

        temp.setId(21);
        temp.setGender(Gender.Female); temp.setFirstName("Мария"); temp.setSecondName("Ильинична");
        temp.setLastName("Милославская");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(21));
        temp.clear();

        temp.setId(22);
        temp.setGender(Gender.Male); temp.setFirstName("Алексей"); temp.setSecondName("Михайлович");
        temp.setStartDay(LocalDate.of(1645, 1, 1));
        temp.setStopDay(LocalDate.of(1676, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(22));
        temp.clear();

        temp.setId(23);
        temp.setGender(Gender.Female); temp.setFirstName("Наталья"); temp.setSecondName("Кирилловна");
        temp.setLastName("Нарышкина");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(23));
        temp.clear();

        temp.setId(31);
        temp.setGender(Gender.Female); temp.setFirstName("Марфа"); temp.setSecondName("Матвеевна");
        temp.setLastName("Апраксина");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(31));
        temp.clear();

        temp.setId(32);
        temp.setGender(Gender.Male); temp.setFirstName("Феодор"); temp.setSecondName("Алексеевич");
        temp.setStartDay(LocalDate.of(1676, 1, 1));
        temp.setStopDay(LocalDate.of(1682, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(32));
        temp.clear();

        temp.setId(33);
        temp.setGender(Gender.Female); temp.setFirstName("Софья"); temp.setSecondName("Алексеевна");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(33));
        temp.clear();

        temp.setId(34);
        temp.setGender(Gender.Male); temp.setFirstName("Иоанн V"); temp.setSecondName("Алексеевич");
        temp.setStartDay(LocalDate.of(1682, 1, 1));
        temp.setStopDay(LocalDate.of(1696, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(34));
        temp.clear();

        temp.setId(35);
        temp.setGender(Gender.Female); temp.setFirstName("Прасковья"); temp.setSecondName("Федоровна");
        temp.setLastName("Салтыкова");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(35));
        temp.clear();

        temp.setId(36);
        temp.setGender(Gender.Female); temp.setFirstName("Евдокия"); temp.setSecondName("Федоровна");
        temp.setLastName("Лопухина");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(36));
        temp.clear();

        temp.setId(37);
        temp.setGender(Gender.Male); temp.setFirstName("Петр I"); temp.setSecondName("Алексеевич");
        temp.setStartDay(LocalDate.of(1682, 5, 30));
        temp.setStopDay(LocalDate.of(1725, 1, 28));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(37));
        temp.clear();

        temp.setId(38);
        temp.setGender(Gender.Female); temp.setFirstName("Екатерина I"); temp.setSecondName("Алексеевна");
        temp.setStartDay(LocalDate.of(1725, 1, 1));
        temp.setStopDay(LocalDate.of(1727, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(38));
        temp.clear();

        temp.setId(41);
        temp.setGender(Gender.Male); temp.setFirstName("Карл"); temp.setSecondName("Леопольд");
        temp.setLastName("Мекленбург-Шверинский");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(41));
        temp.clear();

        temp.setId(42);
        temp.setGender(Gender.Female); temp.setFirstName("Екатерина"); temp.setSecondName("Иоанновна");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(42));
        temp.clear();

        temp.setId(43);
        temp.setGender(Gender.Female); temp.setFirstName("Анна"); temp.setSecondName("Иоанновна");
        temp.setStartDay(LocalDate.of(1730, 1, 1));
        temp.setStopDay(LocalDate.of(1740, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(43));
        temp.clear();

        temp.setId(44);
        temp.setGender(Gender.Male); temp.setFirstName("Фридрих"); temp.setSecondName("Вильгельм");
        temp.setLastName("Курляндский");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(44));
        temp.clear();

        temp.setId(45);
        temp.setGender(Gender.Female); temp.setFirstName("Наталья"); temp.setSecondName("Алексеевна");
        temp.setLastName("Брауншвейг-Вольфенбюттельская");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(45));
        temp.clear();

        temp.setId(46);
        temp.setGender(Gender.Male); temp.setFirstName("Алексей"); temp.setSecondName("Петрович");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(46));
        temp.clear();

        temp.setId(47);
        temp.setGender(Gender.Male); temp.setFirstName("Карл"); temp.setSecondName("Фридрих");
        temp.setLastName("Гольштейн-Готторпский");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(47));
        temp.clear();

        temp.setId(48);
        temp.setGender(Gender.Female); temp.setFirstName("Анна"); temp.setSecondName("Петровна");
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(48));
        temp.clear();

        temp.setId(49);
        temp.setGender(Gender.Female); temp.setFirstName("Елизавета"); temp.setSecondName("Петровна");
        temp.setStartDay(LocalDate.of(1741, 1, 1));
        temp.setStopDay(LocalDate.of(1761, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(49));
        temp.clear();

        temp.setId(53);
        temp.setGender(Gender.Male); temp.setFirstName("Петр II"); temp.setSecondName("Алексеевич");
        temp.setStartDay(LocalDate.of(1727, 1, 1));
        temp.setStopDay(LocalDate.of(1730, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(53));
        temp.clear();

        temp.setId(54);
        temp.setGender(Gender.Female); temp.setFirstName("Екатерина II"); temp.setSecondName("Алексеевна");
        temp.setStartDay(LocalDate.of(1762, 1, 1));
        temp.setStopDay(LocalDate.of(1796, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(54));
        temp.clear();

        temp.setId(55);
        temp.setGender(Gender.Male); temp.setFirstName("Петр III"); temp.setSecondName("Федорович");
        temp.setStartDay(LocalDate.of(1761, 1, 1));
        temp.setStopDay(LocalDate.of(1762, 1, 1));
        PersonSaver.addPerson(temp);
        System.out.println(PersonSaver.getObjectById(55));
        temp.clear();
    }
}

