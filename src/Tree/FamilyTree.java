package Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Tree.Comporators.ComparByAlive;
import Tree.Comporators.ComparByChild;
import Tree.Comporators.ComparByName;
import Tree.Comporators.ComparBySecondName;

public class FamilyTree<E extends Person> implements  Tree<E>,Serializable{

    private List<E> familytree;
    
    /**
     * Создание списка семейного древа 
     */
    public FamilyTree(){
        this(new ArrayList<>());
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
        for(E person: familytree){
            if(person.getFirstName().equalsIgnoreCase(string)){
                System.out.println(person.getInfo());
            }
        }
    }

    public void searchBySecondName(String string) {
        for(E person: familytree){
            if(person.getSecondName().equalsIgnoreCase(string)){
                System.out.println(person.getInfo());
            }
        }    
    }

    public void searchByFullName(String string) {
        for(E person: familytree){
            if(person.getFullName().equalsIgnoreCase(string)){
                System.out.println(person.getInfo());
            }
        }    
    }

    public void searchByDateOfBirth(String string) {
        for(E person: familytree){
            if(person.getDateOfBirth().equalsIgnoreCase(string)){
                System.out.println(person.getInfo());
            }
        }    
    }

    public void searchByAliveOrNot(int i) {
        if(i == 1){
            for(E person: familytree){
                if(person.getAlive().equalsIgnoreCase("Да")){
                    System.out.println(person.getInfo());
                }
            }
        }
        if(i == 2){
            for(E person: familytree){
                if(person.getAlive().equalsIgnoreCase("Нет")){
                    System.out.println(person.getInfo());
                }
            }
        }
    }

    public void searchByDateOfDeath(String string) {
        for(E person: familytree){
            if(person.getDateOfDeath().equalsIgnoreCase(string)){
            System.out.println(person.getInfo());}
        }    
    }

    
    public void sortByName() {
        familytree.sort(new ComparByName<>());
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void sortBySecondName() {
        familytree.sort(new ComparBySecondName<>());
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void sortByAlive() {
        familytree.sort(new ComparByAlive<>());
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void sortByChild() {
        familytree.sort(new ComparByChild<>());
        for(E person: familytree){
            System.out.println(person);
        }
        System.out.println();
    }

    public void dateOfBirth(Integer i) {
        System.out.print(familytree.get(i - 1).getDateOfBirth());
    }

    public void setMother(int mother, int child) {
        familytree.get(child - 1).setMother(familytree.get(mother - 1));
        System.out.println("Человеку " + familytree.get(child - 1).getFullName() + " добавлена мать " + familytree.get(mother - 1).getFullName());
        familytree.get(mother - 1).addChild(familytree.get(child - 1));
    }

    public void setFather(int father, int child) {
        familytree.get(child - 1).setFather(familytree.get(father - 1));
        System.out.println("Человеку " + familytree.get(child - 1).getFullName() + " добавлен отец " + familytree.get(father - 1).getFullName());
        familytree.get(father - 1).addChild(familytree.get(child - 1));
    }

    public void addChild(int person, int child) {
        familytree.get(person - 1).addChild(familytree.get(child - 1));
        System.out.println("Человеку " + familytree.get(person - 1).getFullName() + " добавлен ребёнок " + familytree.get(child - 1).getFullName());
    }

    @Override
    public Iterator<E> iterator(){
        return new PersonIterator<E>(familytree);
    }

    @Override
    public List<Person> getPersonList() {
        return (List<Person>) familytree;
    }

    




}
