package Homework_4;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;


public class Femily_Tree implements Serializable, Iterable<Designer_Human> {//добавил Iterable к
    // конструктору человека
    private static int id;

    private final List<Designer_Human> humans; //константа
//    public Femily_Tree() {
//        humans = new ArrayList();
//    }


//    public List<Designer_Human> getHumans() {
//        return this.humans;
//    }
//    public List<Designer_Human> getHumans(){
//        return humans;
//    }


    public Femily_Tree() {
        super();
        this.humans = new ArrayList<Designer_Human>();
    }

//    public List<Designer_Human> getHumans() {
//        return humans;
//    }

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
     * Метод вывода всех людей из списка
     */
    public void printDrevo(List<Designer_Human> humans) {
        System.out.println(humans);
    }


    public List<Designer_Human> getTree() {
        return this.humans;
    }

    /**
     * метод вывода всех людей из дерева
     */
    public void ShowALL(List<Designer_Human> humans) {
        for (Designer_Human human : this.humans) {
            System.out.println(human.toString());
        }
    }

    /**
     * метод с лямда выражением forEach
     * короткая запись для перебора коллекции. через forEach можно добавлять значение всему списку
     */
    public void printTheTreeForEach() {
        humans.forEach(Designer_Human -> System.out.println(Designer_Human));
        humans.forEach(System.out::println); //указатель на метод выше


    }

    /**
     * Поиск по имени
     *
     * @param name
     * @return Возвращает поле humans
     */
    public List<Designer_Human> showName(String name) {
        for (Designer_Human human : humans) {
            if (Objects.equals(human.getName(), name)) {
                humans.add((Designer_Human) this.humans);
            }
        }
        return humans;
    }

    /**
     * Еще вариант метода добавления людей
     */
    public void addHumansimple(Designer_Human human) {
        this.humans.add(human);
    }

    /**
     * Добавление людей с id
     */
    public void addingPeopleWithAnId(String name, String sex, int date) {
        Designer_Human human = new Designer_Human(id++, name, sex, date);
        Designer_Human.addHumanSimpleMetod(human);
    }

    public void addingPeopleWithAnIdScanner() {
        Scanner iScanner = new Scanner(System.in);
        String name = iScanner.nextLine();
        String sex = iScanner.nextLine();
        int date = iScanner.nextInt();
        Designer_Human human = new Designer_Human(id++, name, sex, date);
        Designer_Human.addHumanSimpleMetod(human);
    }


    /**
     * //     * метод добавления очередной
     */
    @Deprecated
    public void addHumanH(Designer_Human Humman) {
        humans.add(Humman);
    }

    public void searchHuman(ArrayList<Designer_Human> humans) {
        Scanner iScanner = new Scanner(System.in);
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
     * Финишное добавление
     * @param human
     */
    public void addHumanNewHomework4(Designer_Human human) {
        Scanner scanner = new Scanner(System.in);
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
                    human.addHuman(newFio, newSex, newDate);
                }
                this.humans.add(human);
            }
        }
    }

    /**
     * Печать древа
     */
    public void printFamilyTree(Femily_Tree humans) {
        for (Designer_Human HHE : humans) {
            System.out.println(HHE);
        }
        System.out.println();
    }




}



