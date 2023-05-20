package model;

import model.Elements.Human;
import model.Tree.FromTo;
import model.Tree.FromToSerializeFile;
import model.Tree.GenealogicalTree;

import java.util.List;

public class HumanModel implements Model{
    private GenealogicalTree<Human> tree;

    public HumanModel(GenealogicalTree<Human> tree) {
        this.tree = tree;
    }
    public HumanModel(){
        this(new GenealogicalTree<Human>());
    }

    @Override
    public String addElement(String name, int birthday, int deathDay){
        Human human = new Human(name, birthday, deathDay);
        if(!tree.contains(human)){
            tree.addElement(human);
            return "Человек добавлен в древо.";
        }
        return  "Такой человек уже есть.";
    }
    @Override
    public Human findTreeElement(String name) {
        return tree.findElement(name);
    }
    @Override
    public GenealogicalTree<Human> getTreeElementList(){
        return tree;
    }
   @Override
    public String addChildren(String parent, String child){
        if(isAbsent(parent)){
            return "Такого родителя нет.";
        }
        if(isAbsent(child)){
            return "Такого потомка нет.";
        }
        tree.findElement(parent).addChildren(tree.findElement(child));
        return "Потомок добавлен.";
    }
    private boolean isAbsent(String name){
        return tree.findElement(name) == null;
    }
    @Override
    public String setFather(String child, String father ){
        if(isAbsent(child)){
            return "Такого потомка нет.";
        }
        if(isAbsent(father)){
            return "Такого родителя нет.";
        }
        tree.findElement(child).setFather(tree.findElement(father));
        return "Отец установлен.";
    }
    @Override
    public String setMother(String child, String mother ){
        if(isAbsent(child)){
            return "Такого потомка нет.";
        }
        if(isAbsent(mother)){
            return "Такого родителя нет.";
        }
        tree.findElement(child).setMother(tree.findElement(mother));
        return "Мать установлена.";
    }
    public void sort(){
        tree.sort();
    }
    @Override
    public String connectPerson(String nameElement, String nameHuman){
        if(isAbsent(nameElement)){
            return "Такого элемента нет.";
        }
        if(isAbsent(nameHuman)){
            return "Такого человека нет.";
        }
        tree.findElement(nameElement).setSpouse(tree.findElement(nameHuman));
        return "Супруг(а) установлен(а).";
    }
    @Override
    public String save(String fileName){
        FromTo savedFamily = new FromToSerializeFile(fileName);
        savedFamily.saveTo(tree);
        return "Генеалогическое древо сохранено";
    }
    @Override
    public String load(String fileName){
        FromTo loadedFamily = new FromToSerializeFile(fileName);
        this.tree = loadedFamily.readFrom(fileName);
        return "Генеалогическое древо загружено.";
    }
}
