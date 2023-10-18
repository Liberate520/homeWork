import ru.gb.familyTree.person.Gender;
import ru.gb.familyTree.person.Person;
import ru.gb.familyTree.person.PersonBuilder;
import ru.gb.familyTree.tree.FamilyTreeBuilder;
import ru.gb.familyTree.tree.FamilyTree;
import ru.gb.familyTree.tree.Node;
import ru.gb.familyTree.tree.NodeBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

public class Main {
    static Person p11 = new PersonBuilder().createPerson();
    static Person p12 = new PersonBuilder().createPerson();
    static Person p21 = new PersonBuilder().createPerson();
    static Person p22 = new PersonBuilder().createPerson();
    static Person p23 = new PersonBuilder().createPerson();
    static Person p31 = new PersonBuilder().createPerson();
    static Person p32 = new PersonBuilder().createPerson();
    static Person p33 = new PersonBuilder().createPerson();
    static Person p34 = new PersonBuilder().createPerson();
    static Person p35 = new PersonBuilder().createPerson();
    static Person p36 = new PersonBuilder().createPerson();
    static Person p37 = new PersonBuilder().createPerson();
    static Person p38 = new PersonBuilder().createPerson();
    static Person p41 = new PersonBuilder().createPerson();
    static Person p42 = new PersonBuilder().createPerson();
    static Person p43 = new PersonBuilder().createPerson();
    static Person p44 = new PersonBuilder().createPerson();
    static Person p45 = new PersonBuilder().createPerson();
    static Person p46 = new PersonBuilder().createPerson();
    static Person p47 = new PersonBuilder().createPerson();
    static Person p48 = new PersonBuilder().createPerson();
    static Person p49 = new PersonBuilder().createPerson();
    static Person p53 = new PersonBuilder().createPerson();
    static Person p54 = new PersonBuilder().createPerson();
    static Person p55 = new PersonBuilder().createPerson();

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
        n11.setParentOne(p11); n11.setParentTwo(p12); n11.addChildren(p22);
        System.out.println(n11.toString() + "\n");

        n21.setFamily(treeName);n21.setId(21);//2 ряд 1 место
        n21.setParentOne(p21); n21.setParentTwo(p22); n11.addChildren(p32); n11.addChildren(p33); n11.addChildren(p34);
        System.out.println(n21.toString() + "\n");

        n22.setFamily(treeName);n22.setId(22);//2 ряд 2 место
        n22.setParentOne(p22); n22.setParentTwo(p23);n22.addChildren(p37);
        System.out.println(n22.toString() + "\n");

        n31.setFamily(treeName);n31.setId(31);//3 ряд 1 место
        n31.setParentOne(p31); n31.setParentTwo(p32);
        System.out.println(n31.toString() + "\n");

        n32.setFamily(treeName);n32.setId(32);//3 ряд 2 место
        n32.setParentOne(p34); n32.setParentTwo(p35); n32.addChildren(p42);n32.addChildren(p43);
        System.out.println(n32.toString() + "\n");

        n33.setFamily(treeName);n33.setId(33);//3 ряд 3 место
        n33.setParentOne(p36); n33.setParentTwo(p37);n33.addChildren(p46);
        System.out.println(n33.toString() + "\n");

        n34.setFamily(treeName);n34.setId(34);//3 ряд 4 место
        n34.setParentOne(p38); n34.setParentTwo(p37); n34.addChildren(p48);n34.addChildren(p49);
        System.out.println(n34.toString() + "\n");

        n41.setFamily(treeName);n41.setId(41);//4 ряд 1 место
        n41.setParentOne(p41); n41.setParentTwo(p42);
        System.out.println(n41.toString() + "\n");

        n42.setFamily(treeName);n42.setId(42);//4 ряд 2 место
        n42.setParentOne(p43); n42.setParentTwo(p44);
        System.out.println(n42.toString() + "\n");

        n43.setFamily(treeName);n43.setId(43);//4 ряд 3 место
        n43.setParentOne(p45); n43.setParentTwo(p46);
        System.out.println(n43.toString() + "\n");

        n44.setFamily(treeName);n44.setId(43);//4 ряд 4 место
        n44.setParentOne(p47); n44.setParentTwo(p48); n44.addChildren(p55);
        System.out.println(n44.toString() + "\n");

        n52.setFamily(treeName);n52.setId(43);//5 ряд 2 место
        n52.setParentOne(p54); n52.setParentTwo(p55);
        System.out.println(n52.toString() + "\n");
    }

    /**
     * Заполнение персон - участников:
     */
    private static void addPersons(){
        p11.setId(11);//1 ряд 1 место
        p11.setGender(Gender.Male); p11.setFirstName("Михаил"); p11.setSecondName("Фёдорович");
        p11.setStartDay(LocalDate.of(1613, 1, 1));
        p11.setStopDay(LocalDate.of(1645, 1, 1));
        System.out.println(p11.toString());

        p12.setId(12);//1 ряд 2 место
        p12.setGender(Gender.Female); p12.setFirstName("Евдокия"); p11.setSecondName("Лукьяновна");
        p12.setLastName("Стрешнева");
        System.out.println(p12.toString());

        p21.setId(21);
        p21.setGender(Gender.Female); p21.setFirstName("Мария"); p21.setSecondName("Ильинична");
        p21.setLastName("Милославская");
        System.out.println(p21.toString());

        p22.setId(22);
        p22.setGender(Gender.Male); p22.setFirstName("Алексей"); p22.setSecondName("Михайлович");
        p22.setStartDay(LocalDate.of(1645, 1, 1));
        p22.setStopDay(LocalDate.of(1676, 1, 1));
        System.out.println(p22.toString());

        p23.setId(23);
        p23.setGender(Gender.Female); p23.setFirstName("Наталья"); p23.setSecondName("Кирилловна");
        p23.setLastName("Нарышкина");
        System.out.println(p23.toString());

        p31.setId(31);
        p31.setGender(Gender.Female); p31.setFirstName("Марфа"); p31.setSecondName("Матвеевна");
        p31.setLastName("Апраксина");
        System.out.println(p31.toString());

        p32.setId(32);
        p32.setGender(Gender.Male); p32.setFirstName("Феодор"); p32.setSecondName("Алексеевич");
        p32.setStartDay(LocalDate.of(1676, 1, 1));
        p32.setStopDay(LocalDate.of(1682, 1, 1));
        System.out.println(p32.toString());

        p33.setId(33);
        p33.setGender(Gender.Female); p33.setFirstName("Софья"); p33.setSecondName("Алексеевна");
        System.out.println(p33.toString());

        p34.setId(34);
        p34.setGender(Gender.Male); p34.setFirstName("Иоанн V"); p34.setSecondName("Алексеевич");
        p34.setStartDay(LocalDate.of(1682, 1, 1));
        p34.setStopDay(LocalDate.of(1696, 1, 1));
        System.out.println(p34.toString());

        p35.setId(35);
        p35.setGender(Gender.Female); p35.setFirstName("Прасковья"); p35.setSecondName("Федоровна");
        p35.setLastName("Салтыкова");
        System.out.println(p35.toString());

        p36.setId(36);
        p36.setGender(Gender.Female); p36.setFirstName("Евдокия"); p36.setSecondName("Федоровна");
        p36.setLastName("Лопухина");
        System.out.println(p36.toString());

        p37.setId(37);
        p37.setGender(Gender.Male); p37.setFirstName("Петр I"); p37.setSecondName("Алексеевич");
        p37.setStartDay(LocalDate.of(1682, 5, 30));
        p37.setStopDay(LocalDate.of(1725, 1, 28));
        System.out.println(p37.toString());

        p38.setId(38);
        p38.setGender(Gender.Female); p38.setFirstName("Екатерина I"); p38.setSecondName("Алексеевна");
        p38.setStartDay(LocalDate.of(1725, 1, 1));
        p38.setStopDay(LocalDate.of(1727, 1, 1));
        System.out.println(p38.toString());

        p41.setId(41);
        p41.setGender(Gender.Male); p41.setFirstName("Карл"); p41.setSecondName("Леопольд");
        p41.setLastName("Мекленбург-Шверинский");
        System.out.println(p41.toString());

        p42.setId(42);
        p42.setGender(Gender.Female); p42.setFirstName("Екатерина"); p42.setSecondName("Иоанновна");
        System.out.println(p42.toString());

        p43.setId(43);
        p43.setGender(Gender.Female); p43.setFirstName("Анна"); p43.setSecondName("Иоанновна");
        p43.setStartDay(LocalDate.of(1730, 1, 1));
        p43.setStopDay(LocalDate.of(1740, 1, 1));
        System.out.println(p43.toString());

        p44.setId(44);
        p44.setGender(Gender.Male); p44.setFirstName("Фридрих"); p44.setSecondName("Вильгельм");
        p44.setLastName("Курляндский");
        System.out.println(p44.toString());

        p45.setId(45);
        p45.setGender(Gender.Female); p45.setFirstName("Наталья"); p45.setSecondName("Алексеевна");
        p45.setLastName("Брауншвейг-Вольфенбюттельская");
        System.out.println(p45.toString());

        p46.setId(46);
        p46.setGender(Gender.Male); p46.setFirstName("Алексей"); p46.setSecondName("Петрович");
        System.out.println(p46.toString());

        p47.setId(47);
        p47.setGender(Gender.Male); p47.setFirstName("Карл"); p47.setSecondName("Фридрих");
        p47.setLastName("Гольштейн-Готторпский");
        System.out.println(p47.toString());

        p48.setId(48);
        p48.setGender(Gender.Female); p48.setFirstName("Анна"); p48.setSecondName("Петровна");
        System.out.println(p48.toString());

        p49.setId(49);
        p49.setGender(Gender.Female); p49.setFirstName("Елизавета"); p49.setSecondName("Петровна");
        p49.setStartDay(LocalDate.of(1741, 1, 1));
        p49.setStopDay(LocalDate.of(1761, 1, 1));
        System.out.println(p49.toString());

        p53.setId(53);
        p53.setGender(Gender.Male); p53.setFirstName("Петр II"); p53.setSecondName("Алексеевич");
        p53.setStartDay(LocalDate.of(1727, 1, 1));
        p53.setStopDay(LocalDate.of(1730, 1, 1));
        System.out.println(p53.toString());

        p54.setId(54);
        p54.setGender(Gender.Female); p54.setFirstName("Екатерина II"); p54.setSecondName("Алексеевна");
        p54.setStartDay(LocalDate.of(1762, 1, 1));
        p54.setStopDay(LocalDate.of(1796, 1, 1));
        System.out.println(p54.toString());

        p55.setId(55);
        p55.setGender(Gender.Male); p55.setFirstName("Петр III"); p55.setSecondName("Федорович");
        p55.setStartDay(LocalDate.of(1761, 1, 1));
        p55.setStopDay(LocalDate.of(1762, 1, 1));
        System.out.println(p55.toString());
    }
}

