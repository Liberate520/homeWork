package Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Tree.Comporators.ComparByAlive;
import Tree.Comporators.ComparByChild;
import Tree.Comporators.ComparByName;
import Tree.Comporators.ComparBySecondName;

public class FamilyTree<E extends Person> implements Tree<E>,Serializable{

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

    public String searchByFirstName(String string) {
        StringBuilder sb = new StringBuilder();
        for(E person: familytree){
            if(person.getFirstName().equalsIgnoreCase(string)){
                sb.append(person.getFullInfo());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String searchBySecondName(String string) {
        StringBuilder sb = new StringBuilder();
        for(E person: familytree){
            if(person.getSecondName().equalsIgnoreCase(string)){
                sb.append(person.getFullInfo());
                sb.append("\n");
            }
        }
        return sb.toString();    
    }

    public String searchByFullName(String string) {
        StringBuilder sb = new StringBuilder();
        for(E person: familytree){
            if(person.getFullName().equalsIgnoreCase(string)){
                sb.append(person.getFullInfo());
                sb.append("\n");
            }
        }
        return sb.toString();    
    }

    public String searchByDateOfBirth(String string) {
        StringBuilder sb = new StringBuilder();
        for(E person: familytree){
            if(person.getDateOfBirth().equalsIgnoreCase(string)){
                sb.append(person.getFullInfo());
                sb.append("\n");
            }
        }
        return sb.toString();    
    }

    public String searchByAliveOrNot(int i) {
        StringBuilder sb = new StringBuilder();
        if(i == 1){
            for(E person: familytree){
                if(person.getAlive().equalsIgnoreCase("Да")){
                    sb.append(person.getFullInfo());
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        if(i == 2){
            for(E person: familytree){
                if(person.getAlive().equalsIgnoreCase("Нет")){
                    sb.append(person.getFullInfo());
                    sb.append("\n");
                }
            }
            return sb.toString();
        }
        return "Ведено неверное число! \n";
    }

    public String searchByDateOfDeath(String string) {
        StringBuilder sb = new StringBuilder();
        for(E person: familytree){
            if(person.getDateOfDeath().equalsIgnoreCase(string)){
                sb.append(person.getFullInfo());
                sb.append("\n");
            }
        }
        return sb.toString();    
    }

    
    public String sortByName() {
        StringBuilder sb = new StringBuilder();
        familytree.sort(new ComparByName<>());
        for(E person: familytree){
            sb.append(person.getFullInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String sortBySecondName() {
        StringBuilder sb = new StringBuilder();
        familytree.sort(new ComparBySecondName<>());
        for(E person: familytree){
            sb.append(person.getFullInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String sortByAlive() {
        StringBuilder sb = new StringBuilder();
        familytree.sort(new ComparByAlive<>());
        for(E person: familytree){
            sb.append(person.getFullInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String sortByChild() {
        StringBuilder sb = new StringBuilder();
        familytree.sort(new ComparByChild<>());
        for(E person: familytree){
            sb.append(person.getFullInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String setMother(int mother, int child) {
        familytree.get(child - 1).setMother(familytree.get(mother - 1));
        familytree.get(mother - 1).addChild(familytree.get(child - 1));
        return ("Человеку " + familytree.get(child - 1).getFullName() + " добавлена мать " + familytree.get(mother - 1).getFullName());
    }

    public String setFather(int father, int child) {
        familytree.get(child - 1).setFather(familytree.get(father - 1));
        familytree.get(father - 1).addChild(familytree.get(child - 1));
        return ("Человеку " + familytree.get(child - 1).getFullName() + " добавлен отец " + familytree.get(father - 1).getFullName());
    }

    public String addChild(int person, int child) {
        familytree.get(person - 1).addChild(familytree.get(child - 1));
        return ("Человеку " + familytree.get(person - 1).getFullName() + " добавлен ребёнок " + familytree.get(child - 1).getFullName());
    }

    public List<Person> getPersonList() {
        return (List<Person>) familytree;
    }

    @Override
    public Iterator<E> iterator(){
        return new PersonIterator<E>(familytree);
    }

}
