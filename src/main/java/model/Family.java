package model;
import java.util.Iterator;
/**
 * данный класс является моделью
 * построения дерева
 */
public class Family<T>{
    public Person nowPerson = null; //текущий человек(узел дерева)

    public Family(String name) {
        nowPerson = new Person(name, null);
    }

    @Override
    public String toString() {
        return nowPerson.getMyname();
    }

    public void addChild(String parentName, String childName) {
        if (nowPerson != null) {
            Family.addChildFamily(parentName, childName, nowPerson);
        }
    }
    private static void addChildFamily(String parentName, String childName, Person nowPerson) {
        if (nowPerson.getMyname().equals(parentName)) {
            nowPerson.addChild(childName);
        } else {
            for (Person p: nowPerson.getMyChildren()){
                Family.addChildFamily(parentName, childName, p);
            }
 
        }
    }
}
