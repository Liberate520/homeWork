/*
Константину: Очень хочется перейти на сервис и билдер, но нужно тогда перепрописать конструкторы, а у меня пока не вышло - не получается.
Всё же я подзапуталась.

Себе: ПОМНИ!!! Сервис всего лишь описывает функционал нашей программы -
что с её помощью можно делать. Своих методов у него нет, он
создаёт минимальные сущности, с которыми программа должна работать и которые уже описаны
в model (tree и human) - и пользуется чужими методами. Его функция
*/
//TODO допилить создание человека билдером и использование сервиса

package model.service;
import model.familyTree.FamilyTree;
import model.familyTree.FamilyTreeItem;
import model.human.gender.Gender;
import model.human.Human;


import java.io.Serializable;
import java.time.LocalDate;

public class Service {
    private int maxId;
    private FamilyTree<Human> fTree;
//Просто инициализируем дерево одновременно с вызовом сервиса:
    public Service(){
        fTree = new FamilyTree<>();
    }
//Делаем добавку хьюмана.
    //TODO переписать на дженерики (или понять, что не нужно)
    public void addObject(String name, Gender gender, LocalDate birthDay, LocalDate deathDay, Human mother, Human father){
        Human human = new Human(name, gender, birthDay, deathDay, mother, father);
        fTree.addObject(human);
    }
    //здесь, в принципе, так и было
    public String getHumanInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо: \n");
        for (Human human: fTree) {
            stringBuilder.append(human +"\n");
        }
        //чтобы напечатать объект класса FamilyTree, нужно его застринговать, это же пока не текст
        return stringBuilder.toString();
    }
    public void sortByName(){
        fTree.sortByName();
    }

    public void sortByAge(){
        fTree.sortByAge();
    }
    //TODO rewrite method addMother into addChild
    public void addChild(Human parent, Human child){
        fTree.addChild(parent, child);
    }
    public void getMarried(Human wife, Human husband){
        fTree.getMarried(wife, husband);
    }
    //Now it's normal, later I'll add methods like deathDateMaker,
    // divorceMaker, maybe marriageCounter etc


}
