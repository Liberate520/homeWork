package WorkSeminar.Tree;

import WorkSeminar.Persona.Comporators.ComporatorSortAge;
import WorkSeminar.Persona.Comporators.ComporatorSortDEFAUT;
import WorkSeminar.Persona.Comporators.ComporatorSortGender;
import WorkSeminar.Persona.Comporators.ComporatorSortName;
import WorkSeminar.Persona.IteratorPerson;
import WorkSeminar.Persona.Persona;

import java.io.Serializable;
import java.util.*;

public class Tree<P extends TreeEtem> implements Serializable, Iterable<P> {
    private long personID;
    private List<P> personaList;

    public long getPersonID() {
        return personID;
    }
    public void setPersonID(long personID) {
        this.personID = personID;
    }

    public List<P> getPersonaList() {
        return personaList;
    }
    public void setPersonaList(List<P> personaList) {
        this.personaList = personaList;
    }

    public Tree(List<P> personaList) {
        this.personaList = personaList;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public boolean addPersona(P persona){
        if(persona == null) {
            return false;
        }
        if (!personaList.contains(persona)){
            personaList.add(persona);
            persona.setId(personID++);
            addToParents(persona);
            addToKids(persona);

            return true;
        }
        return false;
    }

    private  boolean checkID(long id){
        return  id < personID && id >= 0;
    }


    private void addToParents(P persona){
        for (P par : persona.addParents()){
            par.addKid(persona);
            /*
            Вот здесь у меня основательный затык случился.
            Суть в чём. Подписав Дерево(Tree) на интерфейс(TreeEtem), и изменив все объекты класса Persona,
            на обобщёный параметр P, у меня ественным образом отвалились все методы из Persona.
            Далее, я подписал Persona на созданный для этого инрефейс,
            и принился прописывать в нём болванки требуемых методов, которые уже реализованы в Persona.
            Такие просты методы как gеtName, встали без вопросов на ура.
            Но, методы требуеющие условно Объекты в качестве аргумента, или возрощающие эти "объект", не работают.

            Пример с addKid(persona) выше.
            В качестве аругмента он получает условный обект.
            Допустим, в TreeEtem я в качестве класса я указываю абстрактную P (void addKid(P person);)
            Он начинает ругатся на эту P. Мол, непонятный символ. Ок.
            Попытался записать что-то вроде того, что было на лекции (<P>void addKid(P person);)
            Приводит к тому, но это что класс Persona начинает считать данным метод чем-то другим,
            а не тем, что требует TreeEtem, и требует создать снова void addKid(P person);

            Попытка пропсать просто нейтральный Object, приводит ровно к тому же. (void addKid(Object person);
            Попытка в интерфесе напрямую прописать класс Persona, приводит к тому, что уже в дереве(Tree),
            он ругается на несоотествие ожидаемного и принимаемого типа, мол он ожидает Persona а получает наш P.

            И я вот всё никак не могу сообразить, как записать болванку метода в TreeEtem так,
            что бы не было этого конфликта.
             */
        }
    }
    private void addToKids(P persona) {
        for (P kid : persona.getKids()) {
            kid.addParent(persona);
        }
    }

    public P addID (long id){
        if (!checkID(id)){
            return null;
        }
        for (P key : personaList){
            if(key.getId() == id){
                return key;
            }
        }
        return  null;
    }

    public List<P> getSisBroth(int id){
        P persona = addID(id);
        if (persona == null) {
            return null;
        }
        List<P> sisBrothList = new ArrayList<>();
        for (P partner : persona.addParents()){
            for (P kid : partner.getKids()){
                if (!kid.equals(persona) && !sisBrothList.contains(kid)){
                    sisBrothList.add(kid);
                }
            }
        }
        return sisBrothList;
    }

    public void printSisBroth(List<P> list){
        if(list.size() != 0){
            for (P persona : list) {
                System.out.println(persona);
            }
        }
    }

    public List<P> getNamePersona(String name){
        List<P> NamePersonaList = new ArrayList<>();
        for (P persona : personaList){
            if (persona.getName().equals(name)) {
                NamePersonaList.add(persona);
            }
        }
        return NamePersonaList;
    }

    public boolean setWedding(P personaOne, P personaTwo){
        if(personaOne.getPartner() == null && personaTwo.getPartner() == null) {
            personaOne.setPartner(personaTwo);
            personaTwo.setPartner(personaOne);
            return true;
        } else {
            return false;
        }
    }

    public boolean setWedding(long personaOneId, long personaTwoId){
        if(checkID(personaOneId) && checkID(personaTwoId)) {
            P personaOne = addID(personaOneId);
            P personaTwo = addID(personaTwoId);
            return setWedding(personaOne, personaTwo);
        }
        return false;

    }

    public  String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В семейном древе Грэев ");
        info.append(personaList.size());
        info.append(" членов семьи: \n");
        for (P persona : personaList) {
            info.append(persona);
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public String toString() {return  getInfo();}

    public void sortTreeByName(){
        Collections.sort(personaList, new ComporatorSortName<P>());
    }
    public void sortDefaut(){
        Collections.sort(personaList, new ComporatorSortDEFAUT<P>());
    }
    public void sortTreeByAge(){
        Collections.sort(personaList, new ComporatorSortAge<P>());
    }
    public void sortTreeByGender(){
        Collections.sort(personaList, new ComporatorSortGender<P>());
    }

    @Override
    public Iterator<P> iterator() {
        return new IteratorPerson<>(personaList);
    }
}
