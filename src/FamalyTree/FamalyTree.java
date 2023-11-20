package FamalyTree;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Класс ГЕНЕОЛОГИЧЕССКОЕ ДЕРЕВО
 */

import javax.swing.text.html.HTMLDocument.Iterator;

import FamalyTree.HumanIterator;
import Human.Gender;
import Human.Human;
public class FamalyTree implements Serializable, Iterable<Human> {
    private List<Human> listHuman = new ArrayList<>();

    /**
     * Метод добавления нового человека в генеологическое дерево.
     */
    public void addHuman (){
        Human human = new Human();
        Scanner in = new Scanner(System.in);
        //nextLine(): считывает всю введенную строку
        System.out.print("Введите имя: ");
        human.setName(in.nextLine());
        System.out.print("Введите дату рождения (ГГГГ.MM.ДД): ");
        human.setBirthday(LocalDate.of(in.nextInt(),in.nextInt(),in.nextInt()));
        System.out.print("Введите пол (м,ж): ");
        human.setGender(in.nextLine());
        human.setId(listHuman.size());
        in.close();
        listHuman.add(human);
        //return human;
    }

    /**
     * Метод установления родственных связей
     * @param human0 Человек 1
     * @param human1 Человек 2
     */
    public void addHumanRelatives(Human human0, Human human1){
        Scanner in = new Scanner(System.in);
        System.out.printf("Кем является %s для %s ? \n  1.Отец\n"
        + "2.Мать\n  3.Супруг\n 4.Ребенок",human1.getName(),human0.getName());
        int n = in.nextInt();
        switch (n) {
            case 1:
                human0.setFather(human1);
                human1.addChildren(human0);
                human1.getSpouse()
                      .addChildren(human0);
                break;
            case 2:
                human0.setMather(human1);
                human1.addChildren(human0);
                human1.getSpouse()
                      .addChildren(human0);
                break;
            case 3:
                human0.setSpouse(human1);
                human1.setSpouse(human1);
                break;
            case 4:
                human0.addChildren(human1);
                human0.getSpouse()
                      .addChildren(human1);
                if (human0.getGender() == Gender.Male){
                    human1.setFather(human0);
                    human1.setMather(human0.getSpouse());
                }
                else{
                    human1.setMather(human0);
                    human1.setFather(human0.getSpouse());
                }
                break;
        }
        in.close();
    }

    public void PrintTree() {
        System.out.println("Выводим дерево в консоль");
        for (Human human: listHuman){
            System.out.println(human);
        }
    }

    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(humanList);
    }

}
