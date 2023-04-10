package Tree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Person.*;

public class FamilyTree<E extends Person> implements Tree<E>{

    private List<E> familytree;
    

    /**
     * @param familytree Список семейного древа
     */
    public FamilyTree(List<E> familytree){
        this.familytree = familytree;
    }

    /**
     * Создание списка семейного древа 
     */
    public FamilyTree(){
        this.familytree = new ArrayList<>();
    }

    /**
     * @param person Человек
     * Добавление человека в семейное древо
     */
    public void addPerson(E person){
        familytree.add(person);
    }

    /**
     * @param person Человек
     * @return Добавление человека в семейное древо с проверкой и объединением Отца, Матери и Детей
     */
    public boolean add(E person){
        if (person == null){
            return false;
        }
        int count = 0;
        if (!familytree.contains(person)){
            familytree.add(person);
            if (person.getFather() != null){
                for (int i = 0; i < person.getFather().getChildrens().size(); i++) {
                    if(person.getFather().getChildrens().get(i) == person){
                        count++;
                    }
                }
                if (count == 0){
                    person.getFather().addChild(person);
                }
                count = 0;
            }

            if (person.getMother() != null){
                for (int i = 0; i < person.getMother().getChildrens().size(); i++) {
                    if(person.getMother().getChildrens().get(i) == person){
                        count++;
                    }
                }
                if (count == 0){
                    person.getMother().addChild(person);
                }
                count = 0;
            }
            return true;
        }
        return false;
    }

    /**
     * @return Получение списка семейного древа
     */
    public List<E> getPersonList(){
        return familytree;
    }


    /**
     * @return Получение информации о семейном древе 
     */
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве ");
        sb.append(familytree.size());
        for (int i = 0; i < familytree.size(); i++) {
            if(i * 10 + 5 > familytree.size() && familytree.size() > i * 10 + 1){
                if (15 > familytree.size() && familytree.size() > 11){
                    sb.append(" человек: \n");
                } else {
                    sb.append(" человекa: \n");
                }
                
            }
        }
        for (E person: familytree){
            sb.append(person.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * @param familytree Список семейного древа
     * @param fileName Имя файла
     *  Сохранение семейного древа в файл
     */
    public void save(Tree<Person> familytree, String fileName) {
        StringBuilder sb = new StringBuilder();
        for (Person person: familytree){
            sb.append(person);
            sb.append("\n"); 
        }

        File file = new File(fileName);
        try{
            FileWriter fr = new FileWriter(file,false);
            fr.write(sb.toString());    
            fr.close();
        }
        catch(IOException e) {
            System.out.println("ERROR");
        }
    }

    @Override
    public Iterator<E> iterator(){
        return new PersonIterator<E>(familytree);
    }
}
