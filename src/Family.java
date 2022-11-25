import java.util.Iterator;

public class Family implements function_tree{
    public Person nowPerson = null; //текущий человек(узел дерева)

    public Family(String name, char gender) {
        nowPerson = new Person(name, gender, null);
    }

    private static void printPersonFamily(Person nowPerson, String probel, Integer num) {
        if (nowPerson.getMyChildren() == null)
            System.out.println(nowPerson.getMyname());
        else {
            probel = "   " + probel;
            System.out.println(probel + Integer.toString(num)+": " + nowPerson.getMyname());
            Iterator<Person> iter = nowPerson.getMyChildren().iterator();
            num++;
            while (iter.hasNext()) {
                Family.printPersonFamily(iter.next(), probel, num);
            }
        }
    }    
    @Override
    public void printTree() {
        if (nowPerson != null) {
            Family.printPersonFamily(nowPerson,"потомок ", 0);
        }
    }
    public void addChild(String parentName, String childName, char gender) {
        if (nowPerson != null) {
            Family.addChildFamily(parentName, childName, nowPerson, gender);
        }
    }
 
    private static void addChildFamily(String parentName, String childName, Person nowPerson, char gender) {
        if (nowPerson.getMyname().equals(parentName)) {
            nowPerson.addChild(childName, gender);
        } else {
            Iterator<Person> iter = nowPerson.getMyChildren().iterator();
            while (iter.hasNext()) {
                Family.addChildFamily(parentName, childName, iter.next(), gender);
            }
 
        }
    }

    private static void printChildrenFamily(String Name, Person nowPerson) { //вывод всех детей по имени родителя
        if (nowPerson.getMyname().equals(Name)) {
            System.out.println("родитель - " + nowPerson.toString());
            Iterator<Person> iter = nowPerson.getMyChildren().iterator();
            while (iter.hasNext()) {
                System.out.println("ребенок - " + iter.next().toString());
            }
        } else {
            Iterator<Person> iter = nowPerson.getMyChildren().iterator();
            while (iter.hasNext()) {
                Family.printChildrenFamily(Name, iter.next());
            }

        }
    }
    @Override
    public void printChildren(String Name){
        Family.printChildrenFamily(Name, nowPerson);
    }
}
