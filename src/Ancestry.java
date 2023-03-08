import java.util.ArrayList;
import java.util.List;

import model.Person;

/**
 * 
 */
public class Ancestry {
    private Person mother;
    private Person father;
    private Person curPerson;
    private List<Person> children;
    /**
     * Это описание родословной
     * @param mother Мать
     * @param father Отец
     * @param curPerson Персонаж
     */
    public Ancestry(Person mother, Person father, Person curPerson) {
        this.mother = mother;
        this.father = father;
        this.curPerson = curPerson;
    } 
    public Ancestry(Person curPerson) {
        this(null, null, curPerson);
    }
    public Person getMother() {
        return mother;
    }
    public void setMother(Person mother) {
        this.mother = mother;
    }
    public Person getFather() {
        return father;
    }
    public void setFather(Person father) {
        this.father = father;
    }
    public Person getCurPerson() {
        return curPerson;
    }
    public void setCurPerson(Person curPerson) {
        this.curPerson = curPerson;
    }
    public List<Person> getChildren() {
        return children;
    }
    public void setChildren(List<Person> children) {
        this.children = children;
    } 
    public void addChildren(Person person) {
        if (this.children==null) this.children =  new ArrayList<Person>();
        this.children.add(person);
        // if (this.getCurPerson().getSex() == "male"){
        //     person. .setFather(this);
        // } else {
        //     child.setMother(this);
        // }
    }
    @Override
    public String toString() {
        return "Ancestry \nmother=" + mother + ", \nfather=" + father + ", \ncurPerson=" + curPerson + ", \nchildren="
                + children ;
    } 
    public String сhildrentoSring() {
        Integer count=0;
        String str="Нет такого персонажа";
        if (this.curPerson != null){
            str="У персонажа "+this.curPerson.toString()+" нет детей";
        }
        if (this.children != null){
            str="У персонажа "+this.curPerson.toString()+" есть дети:";
            while (count<this.children.size()){
                str=str+"\n"+count.toString()+". "+this.children.get(count);
                count++;
           }
        }
        return str;
    }

    
    
}
