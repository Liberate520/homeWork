package Homework_5;

import metods.PrintMetods;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

import static java.lang.System.in;


public class Femily_Tree implements Serializable, Iterable<Designer_Human> {//добавил Iterable к конструктору человека
    /*
     *ОПИСАНИЕ КЛАССА
     *В этом классе реализованны методы добавления и поиска + итераторы
     */
    private static int id;


    Designer_Human designer_human;
    PrintMetods printMetods;

    public final List<Designer_Human> humans; //константа


    /**
     * Обязательный конструктор
     */
    public Femily_Tree() {
        super();
        this.humans = new ArrayList<Designer_Human>();
    }
    /*
     *ДОБАВЛЕНИЕ РОДИТЕЛЕЙ
     */

    /**
     * Метод добавления родителе
     */
    public void addParents(Designer_Human human, Designer_Human father, Designer_Human mother) {
        if (father != null) {
            human.setFather(String.valueOf(father));
        }
        if (mother != null) {
            human.setMother(mother);
        }

    }


    /**
     * метод добавления родителей
     *
     * @param human
     */
    public void addParentsScanner(Designer_Human human) {
        Scanner scanner = new Scanner(in);

        System.out.println("Введите имя отца");
        String fatherName = scanner.nextLine();
        System.out.println("Введите имя матери ");
        String motherName = scanner.nextLine();

        if (fatherName != null && !fatherName.equals("")) {
            human.setFather(String.valueOf(new Designer_Human(fatherName)));
        }
        if (motherName != null && !motherName.equals("")) {
            human.setMother(new Designer_Human(motherName));
        }
    }


    /*
     *ПОИСКОВИКИ
     */

    /**
     * Поиск по имени
     *
     * @return Возвращает поле humans
     */
    public List<Designer_Human> showName() {
        Scanner iScanner = new Scanner(in);
        String name = iScanner.nextLine();
        for (Designer_Human human : humans) {
            if (Objects.equals(human.getName(), name)) {
                humans.add((Designer_Human) this.humans);
            }
        }
        return humans;
    }


    /**
     * Поиск человека
     *
     * @param humans
     */
    public void searchHuman(ArrayList<Designer_Human> humans) {
        Scanner iScanner = new Scanner(in);
        System.out.println("Введите имя человека для поиска: ");
        String human = iScanner.nextLine();
        for (Designer_Human с : humans) {
            if (human.equals(с.getName())) {
                System.out.println(с);
            } else {
                System.out.println("Нет людей с таким именем.");
            }
            break;
        }
    }

    /*
     *ДОБАВЛЕНИЕ ЛЮДЕЙ
     */

    /**
     * Вариант добавление людей
     */
    public void addHumanSimple(Designer_Human human) {
        this.humans.add(human);
    }

    /**
     * Вариант добавление людей с id
     */
    public void addingPeopleWithAnId(String name, String sex, int date) {
        Designer_Human human = new Designer_Human(id++, name, sex, date);
        addHumanSimpleMetod(human);
    }

    /**
     * Вариант добавления людей с id + сканер
     */
    public void addingPeopleWithAnIdScanner() {
        Scanner iScanner = new Scanner(in);
        String name = iScanner.nextLine();
        String sex = iScanner.nextLine();
        int date = iScanner.nextInt();
        Designer_Human human = new Designer_Human(id++, name, sex, date);
        addHumanSimpleMetod(human);
    }

    /**
     * Вариант добавления людей
     */
    @Deprecated
    public void addHumanH(Designer_Human Humman) {
        humans.add(Humman);
    }

    /**
     * Финишное добавление
     * Вариант добавления людей + сканер
     *
     * @param human
     */
    public void addHumanNewHomework5(Designer_Human human) {
        Scanner scanner = new Scanner(in);
        String end = "Готово";
        for (; ; ) {
            String newFio = scanner.nextLine();
            if (newFio.equals(end)) ;
            {
                System.out.println(human);
                String newSex = scanner.nextLine();
                if (newSex.equals(end)) ;
                {
                    System.out.println(human);

                    Integer newDate = scanner.nextInt();
                    if (newDate != null && newDate.equals(end)) //Пытался сделать по разному только так сработало
                    //Нужен вывод типа boolean
                    {
                        System.out.println(human);
                        continue;

                    }
//                    human.Designer_Human.addHumansimple();
                    addHuman(newFio, newSex, newDate);
                }
                this.humans.add(human);
            }
        }
    }


    /**
     * Вариант добавления людей + конструктор
     */
    public void addHuman(String name, String sex, int date) {
        Designer_Human HH = new Designer_Human(name, sex, date);
        humans.add(HH);
    }

    /**
     * Вариант добавления людей
     */
    public void addHumanSimpleMetod(Designer_Human Human) {
        humans.add(Human);

    }


    /*
    ДОБАВЛЕНИЕ ДЕТЕЙ
     */

    /**
     * Вариант добавления детей
     */
    public void addChildren() { // добавляем детей другим методом
        StringBuilder Child = new StringBuilder();
        if (designer_human.getChildren() != null) {
            Child.append(designer_human.getName());
            for (Designer_Human c : designer_human.getChildren()) {
                Child.append(c.getName());
            }
        } else {
            Child.append("null");
        }
    }

    /**
     * Вариант добавления детей + сканер
     */
    public void addChildrenScanner() { // добавляем детей другим методом
        System.out.println("Кто твои родители ?");
        printMetods.printDrevo(humans);

        StringBuilder Child = new StringBuilder();
        if (designer_human.getChildren() != null) {

            Child.append(designer_human.getName());
            for (Designer_Human c : designer_human.getChildren()) {
                Child.append(c.getName());
            }
        } else {
            Child.append("null");
        }
    }

    /**
     * метод добавления детей + сканет + финиш
     */
    public void selectChildrenScanner() {
        Scanner scanner = new Scanner(in);
        System.out.println("Пожалуйста, введите имя:");
        String personName = scanner.nextLine();

        Designer_Human human = new Designer_Human(personName);

        System.out.println("Пожалуйста, введите имя отца (или нажмите enter, если оно недоступно) ");
        String fatherName = scanner.nextLine();
        if (!fatherName.isEmpty()) {
            human.setFather(String.valueOf(new Designer_Human(fatherName)));
        }

        System.out.println("Пожалуйста, введите имя матери (или нажмите enter, если оно недоступно). ");
        String motherName = scanner.nextLine();
        if (!motherName.isEmpty()) {
            human.setMother(new Designer_Human(motherName));
        }

        System.out.println("Выбранный человек : " + human);
    }


    /*
     *ИТЕРАТОРЫ
     */
    @Override
    public Iterator<Designer_Human> iterator() {
        return new StaddyIterator(humans);
    }

    @Override
    public void forEach(Consumer<? super Designer_Human> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Designer_Human> spliterator() {
        return Iterable.super.spliterator();
    }

    /**
     * Позволяет перебрать объекты коллекции
     */
    public void enumerationСollection(Femily_Tree femily_tree) {
        /*
         * Позволяет перебрать объекты коллекции
         */

        Iterator<Designer_Human> iterator = femily_tree.iterator();
        while (iterator.hasNext()) {
            Designer_Human HHE = iterator.next();
            System.out.println(HHE);
        }
    }

}


