import java.util.ArrayList;

/**
 * human
 */
public class human {

    /** поля нашего человека */
    private String name;
    //private State state;

    // enum state {
    //     kid, parent, grandparent
    // }

    /** списки для хранения членов семьи */
    private static ArrayList<String> kidsNames;
    private static ArrayList<String> parentsNames;
    private static ArrayList<String> grandParentsNames;

    static {
        kidsNames = new ArrayList<String>();
        parentsNames = new ArrayList<String>();
        grandParentsNames = new ArrayList<String>();
    }

    /** конструктор члена семьи и его перегрузки */
    public human(String name) {
        this.name = name;
    }
    public human() {
        this(" ");
    }

    public String getName() {
        return this.name;
    }
    // public String getState() {
    //     return this.state;
    // }

    // методы человека: иметь детей, иметь родителей (+ в перспективе братья/сетры)
    public void getKids(String name) {
        kidsNames.add(name);
    }
    public void getParents(String name1) {
        parentsNames.add(name1);
    }
    public void getGrandParents(String name2) {
        grandParentsNames.add(name2);
    }

    public void setKids() {
        for (String name : kidsNames) {
            System.out.println(name);
        }
    }
    public void setParents() {
        for (String name : parentsNames) {
            System.out.println(name);
        }
    }
    public void setGrandParents() {
        for (String name : grandParentsNames) {
            System.out.println(name);
        }
    }
}