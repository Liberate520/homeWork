package FamalyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Animal.Animal;
import Animal.AnimalCompByAge;
import Animal.AnimalCompByChildren;
import Animal.AnimalCompByGender;
import Animal.AnimalCompByName;
import Animal.Human.Gender;

import java.util.Iterator;

/**
 * Класс ГЕНЕОЛОГИЧЕССКОЕ ДЕРЕВО
 */
public class FamalyTree<T extends Animal> implements Serializable, Iterable<T> {
    private List<T> listT;

    public FamalyTree(){
        listT = new ArrayList<>();
    }

    /**
     * Метод добавления нового человека в генеологическое дерево.
     */
    public void addT (T t){
        Scanner in = new Scanner(System.in);
        //nextLine(): считывает всю введенную строку
        System.out.print("Введите имя: ");
        t.setName(in.nextLine());
        System.out.print("Введите дату рождения (ГГГГ.MM.ДД): ");
        t.setBirthday(LocalDate.of(in.nextInt(),in.nextInt(),in.nextInt()));
        System.out.print("Введите пол (м,ж): ");
        t.setGender(in.nextLine());
        t.setId(listT.size());
        in.close();
        listT.add(t);
    }

    /**
     * Метод установления родственных связей
     * @param t0 Существо 1
     * @param t1 Существо 2
     */
    public void addTRelatives(T t0, T t1){
        Scanner in = new Scanner(System.in);
        System.out.printf("Кем является %s для %s ? \n  1.Отец\n"
        + "2.Мать\n  3.Супруг\n 4.Ребенок",t1.getName(),t0.getName());
        int n = in.nextInt();
        switch (n) {
            case 1:
                t0.setFather(t1);
                t1.addChildren(t0);
                t1.getSpouse()
                      .addChildren(t0);
                break;
            case 2:
                t0.setMather(t1);
                t1.addChildren(t0);
                t1.getSpouse()
                      .addChildren(t0);
                break;
            case 3:
                t0.setSpouse(t1);
                t1.setSpouse(t1);
                break;
            case 4:
                t0.addChildren(t1);
                t0.getSpouse()
                      .addChildren(t1);
                if (t0.getGender() == Gender.Male){
                    t1.setFather(t0);
                    t1.setMather(t0.getSpouse());
                }
                else{
                    t1.setMather(t0);
                    t1.setFather(t0.getSpouse());
                }
                break;
        }
        in.close();
    }

    public void PrintTree() {
        System.out.println("Выводим дерево в консоль");
        for (T t: listT){
            System.out.println(t);
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new TIterator<T>(listT);
    }

    public void sortByName(){
        listT.sort(new AnimalCompByName<>());
    }

    public void sortByAge(){
        listT.sort(new AnimalCompByAge<>());
    }

    public void sortByGender(){
        listT.sort(new AnimalCompByGender<>());
    }

    public void sortByChildren(){
        listT.sort(new AnimalCompByChildren<>());
    }
}
