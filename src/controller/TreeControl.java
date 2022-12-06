package controller;
import model.*;
import view.ViewConstructor;

import java.util.List;

/*
Сюда будеи обращаться по любому запросу
 */


public class TreeControl {
    private TreeMethods treeMethods;
    private PersonMethods personMethods;
    private ViewConstructor viewConstructor;

    public TreeControl() {
        this.treeMethods = new TreeMethods();
        this.personMethods = new PersonMethods();
        this.viewConstructor = new ViewConstructor(this);
    }


    // Запрос на создание дерева
    public Tree<TreePerson> createTree() {
        return treeMethods.newTree();
    }

    // Запрос на сщздание человека

    public Human createHuman(String name, int gender){
        return personMethods.newHuman(name, gender);
    }

    // Запрос на добавление в дерево

    public void addToTree (TreePerson obj, Tree tree){ // получаем объект (теоретически пригодный) и ссылку на дерево, отправляем на попытку добавления
        treeMethods.add(obj, tree);
//        System.out.println("контроллер отработал");
    }

    public void addToTree (TreePerson[] obj, Tree tree){ // получаем объект (теоретически пригодный) и ссылку на дерево, отправляем на попытку добавления
        for (TreePerson item : obj) {
            treeMethods.add(item, tree);
        }
    }

    /**
* типы связей
     * <p>
* **0, **1 (тоесть первая цифра) гендер (источника) <br>
* *0*, *1* (вторая цивра) возможная реализация кровного родства<br>
* 0**, 1**, 2**... (и все последцющие) тип родства =><br>
*<br>
* 1 = брат/сестра<br>
* 2 = муж/жена<br>
*<br>
*<br>
* 3 = Животное<br>
* 4 = отец/мать<br>
* --<br>
* 5 = сын/дочь<br>
* 6 = Хозяин<br>
*/
    public void createLink (TreePerson first, TreePerson second, int tipeLink){
        personMethods.createLink(first, second, tipeLink);
    }

    public void createLink (TreePerson[] first, TreePerson[] second, int tipeLink){
        for (int i = 0; i < first.length; i++) {
            personMethods.createLink(first[i], second[i], tipeLink);
        }
    }

    public void viewHeirs(Human startPerson){ // построение дерева доступно только людям
        viewConstructor.viewHeirs(startPerson);
    }

    public List<Link> getAllLink(Human person, Character filter){
        return personMethods.getAllLink(person, filter);
    }
//    public void addTree(FamiliesI person);
//
//    public void addTree();
//
//    public void printTree();
//
//    public int getGender();
//
//    public void addLink(Link link);
//
//    public List<Link> getLink();
//    public Link getLink(int i);

//    public void addLink();


}
