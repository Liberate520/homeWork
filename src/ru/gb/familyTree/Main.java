package ru.gb.familyTree;

import ru.gb.familyTree.person.*;
import ru.gb.familyTree.tree.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    private static final boolean debug = false;
    private static final List<Person> db = new ArrayList<>();
    public static void main(String[] args) throws IOException, ClassNotFoundException{
         /**
         * Создание дерева (фрагмент!):
         */
        FamilyTree romanovTree = new FamilyTreeBuilder().setFamily("Романовы").createFamilyTree();
         /**
          * Создание класса для хранения всех персон дерева Романовых:
          */
        PersonSaver romanovPersons = new PersonSaverBuilder().setFamily(romanovTree).createPersonSaver();
         /**
          * Добавление персон Романовых:
          */
        addPersons(romanovPersons);
         /**
          * Добавление узлов в дерево Романовых:
          */
        addNodes(romanovTree, romanovPersons);

        System.out.println("Проверка интерфейса итератора для дерева:\n");
        while (((Iterator<Node>) romanovTree).hasNext()) {
             System.out.println(romanovTree.next());
        }

        System.out.println("Проверка интерфейса итератора для персон:\n");
        while (((Iterator<Person>) romanovPersons).hasNext()) {
            Person itm = romanovPersons.next();
            System.out.println(itm);
            if (itm.getStartDay() !=null) {db.add(itm);}
        }

        /**
         * Реализация сортировки списка персон перед выводом, например по дате правления.
         * Требуется реализовать не менее 2-х, но других полезных сортировок придумать не могу.
         */
        System.out.println("Проверка сортировки по датам правления для персон:\n");
        Collections.reverse(db);
        System.out.println("Массив до сортировки (перевёрнутый):\n");
        for (Person itm:db){
            System.out.println(itm+"\n");
        }
        db.sort(new StartDateComparator());
        System.out.println("Массив после сортировки:\n");
        for (Person itm:db){
            System.out.println(itm+"\n");
        }

         /**
          * Сохранение объектов в файл. Сериализация.
          */
        SaveRestoreTree saver = new SaveRestoreTree();
        saver.writeObject(romanovTree, "romanovTree.out");
        saver.writeObject(romanovPersons, "romanovPersons.out");

        /**
          * Сохранение объектов из файла. Десериализация.
          */
        FamilyTree romanovTreeRestored = (FamilyTree) saver.restoreObject("romanovTree.out");
        if(debug){System.out.println("Проверка корректности объекта после восстановления:\n");}
        if(debug){System.out.println(romanovTreeRestored.getObjectById(11) + "\n");}
        if(debug){System.out.println(romanovTreeRestored.getObjectById(21) + "\n");}
        if(debug){System.out.println(romanovTreeRestored.getObjectById(22) + "\n");}

        PersonSaver romanovPersonsRestored = (PersonSaver) saver.restoreObject("romanovPersons.out");
        if(debug){System.out.println("Проверка корректности объекта после восстановления:\n");}
        if(debug){System.out.println(romanovPersonsRestored.getObjectById(37) + "\n");}
        if(debug){System.out.println(romanovPersonsRestored.getObjectById(53) + "\n");}
        if(debug){System.out.println(romanovPersonsRestored.getObjectById(55) + "\n");}

    }

    /**
     * Заполнение дерева узлами (браками):
     */
    private static void addNodes(FamilyTree treeName, PersonSaver personName){
        Node tempNode = new NodeBuilder().createNode();
        tempNode.setFamily(treeName);tempNode.setId(11);//1 ряд 1 место
        tempNode.setParentOne(personName.getObjectById(11)); tempNode.setParentTwo(personName.getObjectById(12));
        tempNode.addChildren(personName.getObjectById(22));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(11) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(21);//2 ряд 1 место
        tempNode.setParentOne(personName.getObjectById(21)); tempNode.setParentTwo(personName.getObjectById(22));
        tempNode.addChildren(personName.getObjectById(32)); tempNode.addChildren(personName.getObjectById(33));
        tempNode.addChildren(personName.getObjectById(34));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(21) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(22);//2 ряд 2 место
        tempNode.setParentOne(personName.getObjectById(22)); tempNode.setParentTwo(personName.getObjectById(23));
        tempNode.addChildren(personName.getObjectById(37));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(22) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(31);//3 ряд 1 место
        tempNode.setParentOne(personName.getObjectById(31)); tempNode.setParentTwo(personName.getObjectById(32));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(31) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(32);//3 ряд 2 место
        tempNode.setParentOne(personName.getObjectById(34)); tempNode.setParentTwo(personName.getObjectById(35));
        tempNode.addChildren(personName.getObjectById(42));tempNode.addChildren(personName.getObjectById(43));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(32) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(33);//3 ряд 3 место
        tempNode.setParentOne(personName.getObjectById(36)); tempNode.setParentTwo(personName.getObjectById(37));
        tempNode.addChildren(personName.getObjectById(46));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(33) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(34);//3 ряд 4 место
        tempNode.setParentOne(personName.getObjectById(37)); tempNode.setParentTwo(personName.getObjectById(38));
        tempNode.addChildren(personName.getObjectById(48));tempNode.addChildren(personName.getObjectById(49));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(34) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(41);//4 ряд 1 место
        tempNode.setParentOne(personName.getObjectById(41)); tempNode.setParentTwo(personName.getObjectById(42));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(41) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(42);//4 ряд 2 место
        tempNode.setParentOne(personName.getObjectById(43)); tempNode.setParentTwo(personName.getObjectById(44));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(42) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(43);//4 ряд 3 место
        tempNode.setParentOne(personName.getObjectById(45)); tempNode.setParentTwo(personName.getObjectById(46));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(43) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(44);//4 ряд 4 место
        tempNode.setParentOne(personName.getObjectById(47)); tempNode.setParentTwo(personName.getObjectById(48));
        tempNode.addChildren(personName.getObjectById(55));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(44) + "\n");}
        tempNode.clear();

        tempNode.setFamily(treeName);tempNode.setId(52);//5 ряд 2 место
        tempNode.setParentOne(personName.getObjectById(54)); tempNode.setParentTwo(personName.getObjectById(55));
        treeName.addNode(tempNode);
        if(debug){System.out.println(treeName.getObjectById(52) + "\n");}
        tempNode.clear();
    }

    /**
     * Заполнение персон - участников:
     */
    private static void addPersons(PersonSaver personName){
        Person tempPerson = new PersonBuilder().createPerson();
        tempPerson.setId(11);//1 ряд 1 место
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Михаил"); tempPerson.setSecondName("Фёдорович");
        tempPerson.setStartDay(LocalDate.of(1613, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1645, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(11));}
        tempPerson.clear();

        tempPerson.setId(12);//1 ряд 2 место
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Евдокия"); tempPerson.setSecondName("Лукьяновна");
        tempPerson.setLastName("Стрешнева");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(12));}
        tempPerson.clear();

        /**
         * Намеренно дублируем персону. В дерево персона попасть не должна.
         */
        tempPerson.setId(66);//намеренно дублирована
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Евдокия"); tempPerson.setSecondName("Лукьяновна");
        tempPerson.setLastName("Стрешнева");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(66));}
        tempPerson.clear();

        tempPerson.setId(21);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Мария"); tempPerson.setSecondName("Ильинична");
        tempPerson.setLastName("Милославская");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(21));}
        tempPerson.clear();

        tempPerson.setId(22);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Алексей"); tempPerson.setSecondName("Михайлович");
        tempPerson.setStartDay(LocalDate.of(1645, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1676, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(22));}
        tempPerson.clear();

        tempPerson.setId(23);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Наталья"); tempPerson.setSecondName("Кирилловна");
        tempPerson.setLastName("Нарышкина");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(23));}
        tempPerson.clear();

        tempPerson.setId(31);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Марфа"); tempPerson.setSecondName("Матвеевна");
        tempPerson.setLastName("Апраксина");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(31));}
        tempPerson.clear();

        tempPerson.setId(32);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Феодор"); tempPerson.setSecondName("Алексеевич");
        tempPerson.setStartDay(LocalDate.of(1676, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1682, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(32));}
        tempPerson.clear();

        tempPerson.setId(33);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Софья"); tempPerson.setSecondName("Алексеевна");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(33));}
        tempPerson.clear();

        tempPerson.setId(34);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Иоанн V"); tempPerson.setSecondName("Алексеевич");
        tempPerson.setStartDay(LocalDate.of(1682, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1696, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(34));}
        tempPerson.clear();

        tempPerson.setId(35);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Прасковья"); tempPerson.setSecondName("Федоровна");
        tempPerson.setLastName("Салтыкова");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(35));}
        tempPerson.clear();

        tempPerson.setId(36);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Евдокия"); tempPerson.setSecondName("Федоровна");
        tempPerson.setLastName("Лопухина");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(36));}
        tempPerson.clear();

        tempPerson.setId(37);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Петр I"); tempPerson.setSecondName("Алексеевич");
        tempPerson.setStartDay(LocalDate.of(1682, 5, 30));
        tempPerson.setStopDay(LocalDate.of(1725, 1, 28));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(37));}
        tempPerson.clear();

        tempPerson.setId(38);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Екатерина I"); tempPerson.setSecondName("Алексеевна");
        tempPerson.setStartDay(LocalDate.of(1725, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1727, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(38));}
        tempPerson.clear();

        tempPerson.setId(41);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Карл"); tempPerson.setSecondName("Леопольд");
        tempPerson.setLastName("Мекленбург-Шверинский");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(41));}
        tempPerson.clear();

        tempPerson.setId(42);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Екатерина"); tempPerson.setSecondName("Иоанновна");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(42));}
        tempPerson.clear();

        tempPerson.setId(43);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Анна"); tempPerson.setSecondName("Иоанновна");
        tempPerson.setStartDay(LocalDate.of(1730, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1740, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(43));}
        tempPerson.clear();

        tempPerson.setId(44);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Фридрих"); tempPerson.setSecondName("Вильгельм");
        tempPerson.setLastName("Курляндский");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(44));}
        tempPerson.clear();

        tempPerson.setId(45);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Наталья"); tempPerson.setSecondName("Алексеевна");
        tempPerson.setLastName("Брауншвейг-Вольфенбюттельская");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(45));}
        tempPerson.clear();

        tempPerson.setId(46);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Алексей"); tempPerson.setSecondName("Петрович");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(46));}
        tempPerson.clear();

        tempPerson.setId(47);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Карл"); tempPerson.setSecondName("Фридрих");
        tempPerson.setLastName("Гольштейн-Готторпский");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(47));}
        tempPerson.clear();

        tempPerson.setId(48);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Анна"); tempPerson.setSecondName("Петровна");
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(48));}
        tempPerson.clear();

        tempPerson.setId(49);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Елизавета"); tempPerson.setSecondName("Петровна");
        tempPerson.setStartDay(LocalDate.of(1741, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1761, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(49));}
        tempPerson.clear();

        tempPerson.setId(53);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Петр II"); tempPerson.setSecondName("Алексеевич");
        tempPerson.setStartDay(LocalDate.of(1727, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1730, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(53));}
        tempPerson.clear();

        tempPerson.setId(54);
        tempPerson.setGender(Gender.Female); tempPerson.setFirstName("Екатерина II"); tempPerson.setSecondName("Алексеевна");
        tempPerson.setStartDay(LocalDate.of(1762, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1796, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(54));}
        tempPerson.clear();

        tempPerson.setId(55);
        tempPerson.setGender(Gender.Male); tempPerson.setFirstName("Петр III"); tempPerson.setSecondName("Федорович");
        tempPerson.setStartDay(LocalDate.of(1761, 1, 1));
        tempPerson.setStopDay(LocalDate.of(1762, 1, 1));
        personName.addPerson(tempPerson);
        if(debug){System.out.println(personName.getObjectById(55));}
        tempPerson.clear();
    }
}

