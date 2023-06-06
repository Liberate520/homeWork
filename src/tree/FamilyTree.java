package tree;

import javax.xml.namespace.QName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
* у него будет список людей и методы работы с этим списком
* добавить нового человека в дерево или найти в дереве
* как вендинг машин из примера семинара*/
public class FamilyTree implements Serializable {
    private List<Human> personList;

    public FamilyTree() { this(new ArrayList<>()); }

    public FamilyTree(List<Human> humanList) {
        this.personList = humanList;
    }

    public boolean add(Human human){
        if(human == null) {
            return false;
        }
        if(!personList.contains(human)) {
            personList.add(human);
            if(human.getFather() != null) {
                human.getFather().childAdd(human);
            }
            if (human.getMother() != null) {
                human.getMother().childAdd(human);
            }
            return true;
        }
        return false;
    }

    public Human findPerson(String name) {
        for(Human human: personList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String findHuman() {
        StringBuilder find = new StringBuilder(); // создаем экземпляр класса СтрингБилдер
        find.append("Find: ");
        find.append(personList.size());
        find.append(" records: \n");
        for(Human human: personList){
            find.append(human.getInfo());
            find.append("\n");
        }
        return find.toString();
    }
}
