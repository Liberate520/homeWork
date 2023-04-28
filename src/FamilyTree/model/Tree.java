package FamilyTree.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import FamilyTree.model.iterators.NodeIterator;
import FamilyTree.model.nodes.Node;

import java.io.Serializable;
import java.lang.StringBuilder;

public class Tree <E extends Node> implements Serializable, Iterable<E>{
    static final long SerialVersionUID = 2024;//задан вручную, иначе при изменениях в проекте UID генерируется заново и старое сохранение не работает
    private List<E> family;
    public Tree(List<E> nodes){//конструктор создание дерева из списка записей
        family = nodes;
    }

    public Tree(){//перегрузка конструктора, без параметра будет создавать пустой список
        this(new ArrayList<>());
    }

    public void addNode (E addedNode, E father, E mother){////////////////метода добавления новой записи в дерево///
        family.add(addedNode);//добавить проверку, есть ли уже в дереве такой человек
        if(father != null)//если родители есть, добавляем им информацию о ребенке 
            father.addChild(addedNode);
        if(mother != null){   
            mother.addChild(addedNode);
        }      
    }

    public void addNode (E addedNode){//перегрузка метода для случая, когда родители не известны
        addNode(addedNode, null,null);
    }

    public List<E> getNodeList() {
        return family;
    }

    public String showNodeList(List<E> nodes) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nodes.size(); i++){
            sb.append(i+1).append(" ").append(nodes.get(i)).append("\n");//когда в append передаем элемент листа, к нему применяется toString
                                                                                //toString у каждого потомка node свой
        }
        return sb.toString();
    }

    public List<E> findNodes (String searchText) {
        List<E> foundNodes = new ArrayList<>();
        for(int i = 0; i < family.size(); i++){
            if(family.get(i).search(searchText)){//если в текстовых полях записи содержится искомый текст, она попадет в список найденных
                foundNodes.add(family.get(i)); 
            }
        }
        return foundNodes;
    }

    public void deleteNode(int index){
        if(index >=0 && index < family.size()){
            family.remove(index);
        }
    }

    @Override
    public String toString(){
        return showNodeList(family);
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<E>(family);
    }
}
