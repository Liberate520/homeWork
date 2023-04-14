package Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ui.Sort;

public class FamilyTree<E extends Person> implements Tree<E>, Serializable{

    private List<E> familytree;
    private Person person;
    Sort familyIterator = new Sort(familytree);
    
    /**
     * Создание списка семейного древа 
     */
    public FamilyTree(){
        this(new ArrayList<>());
    }
    /**
     * @return Получение списка семейного древа
     */
    public List<E> getPersonList(){
        return familytree;
    }

    
    /**
     * @param familytree Список семейного древа
     */
    public FamilyTree(List<E> familytree){
        this.familytree = familytree;
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
                if(person.getFather().getChildrens().contains(person))
                    {count++;}

                if (count == 0){
                    person.getFather().addChild(person);
                }
                count = 0;
            }
            if (person.getMother() != null){
                if(person.getMother().getChildrens().contains(person))
                    {count++;}

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

    public void searchByFirstName(String string) {
        if(familytree.contains(string)){System.out.print(person.getInfo());}
    }

    public void searchBySecondName(String string) {
        if(familytree.contains(string)){System.out.print(person.getInfo());}
    }

    public void searchByFullName(String string) {
        if(familytree.contains(string)){System.out.print(person.getInfo());}
    }

    public void searchByDateOfBerth(String string) {
        if(familytree.contains(string)){System.out.print(person.getInfo());}
    }

    public void searchByAliveOrNot(int i) {
        if(i == 1){if(familytree.contains("Жив")){System.out.print(person.getInfo());}}
        if(i == 2){if(familytree.contains("Мертв")){System.out.print(person.getInfo());}}
    }

    public void searchByDateOfDeath(String string) {
        if(familytree.contains(string)){System.out.print(person.getInfo());}
    }

    
    public void sortByName() {
        familyIterator.sortByName();
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void sortBySecondName() {
        familyIterator.sortBySecondName();
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void sortByAlive() {
        familyIterator.sortByAlive();
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void sortByChild() {
        familyIterator.sortByChild();
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void dateOfBirth(Integer i) {
        System.out.print(familytree.get(i - 1).getDateOfBirth());
    }




    

    @Override
    public Iterator<E> iterator(){
        return new PersonIterator<E>(familytree);
    }

}
