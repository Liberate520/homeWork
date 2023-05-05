import java.util.ArrayList;
import java.util.List;

class Parent implements ParentInterface {
    private String name;
    private char gender;
    private String dob;
    private List<Person> children;
    public Parent(String n, char g, String d) {
        name = n;
        gender = g;
        dob = d;
        children = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public char getGender() {
        return gender;
    }
    
    public String getDOB() {
        return dob;
    }
    
    public List<Person> getChildren() {
        return children;
    }
    
    public void addChild(Person child) {
        children.add(child);
    }
    }
