import java.util.Iterator;

public class Family {
    public Person nowPerson = null; //текущий человек(узел дерева)

    public Family(String name, char gender) {
        nowPerson = new Person(name, gender, null);
    }

    private static void printPersonFamily(Person nowPerson, String probel) {
        if (nowPerson.myChildren == null)
            System.out.println(nowPerson.myname);
        else {
            probel = probel + "    ";
            System.out.println(probel + nowPerson.myname);
            Iterator<Person> iter = nowPerson.myChildren.iterator();
            while (iter.hasNext()) {
                Family.printPersonFamily(iter.next(), probel);
            }
        }
    }    
    public void printFamily() {
        if (nowPerson != null) {
            Family.printPersonFamily(nowPerson, " ");
        }
    }
    public void addChild(String parentName, String childName, char gender) {
        if (nowPerson != null) {
            Family.addChildFamily(parentName, childName, nowPerson, gender);
        }
    }
 
    private static void addChildFamily(String parentName, String childName, Person nowPerson, char gender) {
        if (nowPerson.myname.equals(parentName)) {
            nowPerson.addChild(childName, gender);
        } else {
            Iterator<Person> iter = nowPerson.myChildren.iterator();
            while (iter.hasNext()) {
                Family.addChildFamily(parentName, childName, iter.next(), gender);
            }
 
        }
    }
 
}
